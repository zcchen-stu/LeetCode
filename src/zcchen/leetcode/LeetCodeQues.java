package zcchen.leetcode;

public class LeetCodeQues {
	
	/**
	 * 
	 * @author zcchen
	 * 链表节点内部类
	 */
	static class ListNode{
		int val;
		ListNode next;
		
		ListNode(int value) {
			this.val = value;
		}
		
		boolean hasNext() {
			return next != null;
		}
	}
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = new String[] {"nchenzhenchang", "niu", "nice"};
		System.out.println(getLongPrefix(strs));
		
		// 两数之和算法 1999 + 21
				ListNode l1 = new ListNode(9);
				ListNode l_1 = new ListNode(9);
				ListNode l_2 = new ListNode(9);
				ListNode l_3 = new ListNode(1);
				l_1.next = l_2;
				l_2.next = l_3;
				l1.next = l_1;
				
				ListNode l2 = new ListNode(1);
				ListNode l2_1 = new ListNode(8);
				ListNode l2_2 = new ListNode(1);
				ListNode l2_3 = new ListNode(2);
				l2.next = l2_1;
				l2_1.next = l2_2;
				l2_2.next = l2_3;
				ergodicLink(l1);
				System.out.println("");
				ergodicLink(addTwoNumbers(l1,l2));
		
	}

	/**
	 * 获取最长公共字串
	 * @param strs
	 * @return
	 */
	private static String getLongPrefix(String[] strs) {
		if(strs.length <= 0) {
			return "";
		}else if (strs.length == 1) {
			return strs[0];
		}
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			boolean isFit = true;
			for(int j = 1; j < strs.length; j++) {
				if( !(i < strs[j].length() && strs[j].charAt(i) == c) ) {
					isFit = false;
				}
			}
			if(isFit) {
				builder.append(c);
			}
		}
		return builder.toString();
	}
	
	public static String getLongPrefix2(String[] strs) {
		if(strs.length <= 0) {
			return "";
		}
		String prefix = strs[0];
		for(int i = 0; i < strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0,prefix.length() - 1);
				if(prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode result = new ListNode(0);
        head.next = result;
        int ext  = 0;
        while(l1 != null || l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            int sum= v1 + v2 + ext;
            ListNode singleDigits = new ListNode(0);
            if(sum >= 10) {
            	singleDigits.val = sum % 10;
            	ext = 1;
            }else {
            	singleDigits.val = sum; 
            	ext = 0;
            }
            result.next = singleDigits;
            result = singleDigits;
            
            // 继续循环
            l1 = l1.next;
            l2 = l2.next;
            
           if(l1 == null || l2 == null) {
        	   //若一个列表已经遍历完，则将另一个链表的依次加入
               addExt(l1, l2, result, ext);
               break;
           }
        }
        return head.next.next;
    }
	
	public static void addExt(ListNode l1, ListNode l2, ListNode result, int ext) {
		ListNode last;
		if(l1 == null) {
			last = l2;
		}else {
			last = l1;
		}
		if(last == null) {
			if(ext > 0) {
				result.next = new ListNode(ext);
			}
			return;
		}
		
		if(ext == 0) {
			result.next = last;
		}else {
			ListNode newResult = new ListNode(0);
			int sum = (/* result.value + */ext + last.val) % 10;
			ext =  ext + last.val >= 10 ? 1 : 0;
			result.next = newResult;
			newResult.val = sum;
			addExt(null, last.next, newResult, ext);
		}
		
	}
	
	public static void ergodicLink(ListNode links) {
		while(links.hasNext()) {
			System.out.print(links.val);
			System.out.print(" -> ");
			links = links.next;
		}
		System.out.print(links.val);
	}

}
