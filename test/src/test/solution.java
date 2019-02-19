package test;

import java.util.Hashtable;
import java.util.Stack;

public class solution {
    public static boolean isValid(String s) {  //����ƥ��
        Stack sta = new Stack();
        char[] in_string = s.toCharArray();
        
        for(int i=0;i<in_string.length;i++)
        {
            Character ch = s.charAt(i);
            if(ch=='{'||ch=='['||ch=='(')
            {
            	 sta.push(ch);
            }
            else
            {
            	if(sta.empty()==true) return false;
            	else
            	{
            		if(ismatched(ch,(char)sta.peek())==true) 
            		{
            			sta.pop();
            		}
            		else return false;
            	}
            }          
        }
        if(sta.empty()==true) return true;
        else return false;
    }
    
    public static boolean ismatched(char s1,char s2)
    {
    	if(s1==']'&&s2=='[') return true;
    	if(s1=='}'&&s2=='{') return true;
    	if(s1==')'&&s2=='(') return true;
		return false;
    	
    }
    
    @SuppressWarnings("unused")
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {  //��������ĺϲ�
    	ListNode newlist = new ListNode(0);
        ListNode temp = newlist;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null){
            temp.next = l1;
        }else{
            temp.next = l2;
        }
        return newlist.next; //��ͷ�ڵ�
        
    }
    
    
    
    public static int removeDuplicates(int[] nums) {   //�Ƴ��ظ�Ԫ�أ�Ҫ�󲻶��⿪�������ṩO��1���Ķ����ڴ�
    	Hashtable number = new Hashtable();
    	int k = 0;
    	int leng = nums.length;
    	for(int i=0;i<leng;i++)
    	{
    		number.put(i, nums[i]);
    	}
    	
    	while(k+1<leng)
    	{
    		if(number.get(k+1)==number.get(k))
    		{
    			number.remove(k);
    		}
    		k++;
    	}
    	
		return number.size();
        
    }
    
    public int removeElement(int[] nums, int val) {
        int i=0;
        int j=0;
        int count=0;
        while(j<nums.length)
        {
        	if(nums[j]!=val)
        	{
        		nums[i]=nums[j];
        		i++;
        		count++;
        	}
        
        	j++;
        }
    
		return count;
    }
    
    public static void main(String[] args)
    {
//    	boolean isok = isValid("(([]){})");
//    	System.out.println(isok);//��֤����ƥ��
    	int[] testarray= {0,0,1,1,1,2,2,3,3,4};
    	System.out.println(removeDuplicates(testarray));
    	
    }
}
