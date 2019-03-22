package test;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Stack;

public class solution {
	
	/**************************����ƥ������************************/
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
    /***************************����*****************************/
    
    /**************************��������ϲ����������µ��ڴ�************************/
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
    /***************************����*****************************/
    
    /*******************�Ƴ��ظ�Ԫ��**********************/
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
    /***************************����*****************************/
    
    /***************************ɾ��ָ��Ԫ��*****************************/
    public int removeElement(int[] nums, int val) {  //ɾ��ָ��Ԫ��
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
    /***************************����*****************************/
    
    /***************************��������ӷ�*****************************/
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) { //�����������ӷ�
	   ListNode newlist = new ListNode(0);
	   ListNode temp = newlist;
	   ListNode p = l1;
	   ListNode q = l2;
	   int sum;
	   int t=0;//��ʾ��λ
	   while(p!=null||q!=null)
	   {
		   int x = (p!=null)?p.val:0;
		   int y = (q!=null)?q.val:0;
		   sum = x+y+t;
		   t = sum/10;
		   temp.next = new ListNode(sum%10);
		   temp = temp.next;
		   if(p!=null) p = p.next;
		   if(q!=null) q = q.next; 
	   }
	   if(t>0) //��λ���н�λ������λ��Ϊ�׸�����
	   {
		   temp.next = new ListNode(t);
	   }
	   
	   return newlist.next; //ע�ⲻҪ����temp.next������Ϊ�ƶ�ָ�룬����������ĩβ�Ľڵ�
    }
   /***************************����*****************************/
   
   /*****************����ظ��ִ��ĵ�һ���汾**************/
   public static int lengthOfLongestSubstring(String s) { // ����ظ��ִ���ע�ⲻ�������У��Ӵ�Ҫ��ÿ�����ַ�������
	   int leng = s.length();
	   int max = 0;
	   for(int i=0;i<leng;i++)
	   {
		   for(int j=i+1;j<=leng;j++)
		   {
			   if(allUnique(s, i, j))
			   {
				   if((j-i)>max) max = j-i;
			   }
		   }
	   }
	   
	   return max;
       
   }
   public static boolean allUnique(String s, int start, int end) { //����hashset�ж��ַ����Ƿ����ظ��ַ�
	   Set<Character> set = new HashSet<>();
	   for(int i=start;i<end;i++)
	   {
		   Character ch = s.charAt(i);
		   if(set.contains(ch)) return false;
		   else set.add(ch);
	   }
	   return true;
	   
   }
   /*******************����**********************/
   
   /*******************��ִ��ļ��ٰ�**********************/
   public int lengthOfLongestSubstring1(String s) {  //��ִ��ļ��ٰ棬���û�������ԭ���жϹ����ִ������ٴ��ж��ظ���
       int n = s.length();
       Set<Character> set = new HashSet<>();
       int ans = 0, i = 0, j = 0;
       while (i < n && j < n) {
           // try to extend the range [i, j]
           if (!set.contains(s.charAt(j))){
               set.add(s.charAt(j++));
               ans = Math.max(ans, j - i);
           }
           else {
               set.remove(s.charAt(i++));
           }
       }
       return ans;
   }
   /*******************����**********************/
   
   
   /*******************�ҳ�������Ӵ�**********************/
   public String longestPalindrome(String s) {  //�ҳ�������Ӵ�
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i); //���������ĵ�����
	        int len2 = expandAroundCenter(s, i, i + 1);  //ż�������ĵ�����
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start =   i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	/*******************����**********************/
	
	/****************************���ַ������״���**************************/
	 public String convert(String s, int numRows) {

	        if (numRows == 1) return s;

	        StringBuilder ret = new StringBuilder();
	        int n = s.length();
	        int cycleLen = 2 * numRows - 2;

	        for (int i = 0; i < numRows; i++) {
	            for (int j = 0; j + i < n; j += cycleLen) {  //j��ʾ�ڵڼ���ѭ�����棨һ�־��״ѭ������2rows-2���ַ���
	                ret.append(s.charAt(j + i));
	                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) //һ������ÿ����������ַ�
	                    ret.append(s.charAt(j + cycleLen - i));
	            }                                                                                                                
	        }
	        return ret.toString();
	    }
	 /**************************����************************/
	 
	 /*********************��ת����*******************/
	 public static int reverse(int x) {
		 int p = 0;
		 int pop;
		 while(x!=0)
		 {
			 pop = x % 10;
			 x = x/10;
			 if(p > Integer.MAX_VALUE/10 || p == Integer.MAX_VALUE/10 && pop > 8) return 0;//����int�������ʱʧ��
			 if(p < Integer.MIN_VALUE/10 || p == Integer.MIN_VALUE/10 && pop < -8) return 0;//С��int����С��ʱʧ��
			 p = p*10 + pop;
		 }
		return p;
	        
	    }
	 /**************************����************************/
	 
	  /***************�����淴ת�������ƣ��ж������Ƿ�Ϊ����ϵ��*************/
	 public static boolean isPalindrome(int x) {
	        if(x<0) return false;
	        int xnew = x;
	        int y = 0;
	        int pop;
	        while(xnew!=0)
	        {
	        	pop = xnew % 10;
	        	xnew = xnew/10;
	        	if(y > Integer.MAX_VALUE/10 || y == Integer.MAX_VALUE/10 && pop > 8) return false;//����int�������ʱʧ��
				if(y < Integer.MIN_VALUE/10 || y == Integer.MIN_VALUE/10 && pop < -8) return false;//С��int����С��ʱʧ��
	        	y = y*10 + pop;
	        }
	        if (x==y) return true;
	        else return false;  
	    }
	 /**************************����************************/
	 
	 /*************************��������ж�***********************/
	 public static int maxArea(int[] height) {  /**********��ͨ����ʱ�临�Ӷ�ΪO(n��)**********/
		int area;
		int ans = 0;
		for(int i=0;i<height.length;i++)
		{
			for(int j=i+1;j<height.length;j++)
			{
				area = (j-i)*Math.min(height[i], height[j]); //�˷���̫�򵥣����ӶȽϸߣ�Ҳ�������ڴ�
				ans = Math.max(ans, area);
			}
		}
		 
		return ans;  
	        
	    }
	 
	 public int maxArea1(int[] height) {  /********���ٰ棬����ָ�룬���������ҿ�ʼ�ֱ����м��ƶ�***********/
	        int maxarea = 0, l = 0, r = height.length - 1;
	        while (l < r) {
	            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
	            if (height[l] < height[r])
	                l++;
	            else
	                r--;
	        }
	        return maxarea;
	    }
	 /**************************����************************/
	 
	 /*************************��������ת����������***********************/
	 public static int romanToInt(String s) {
		int leng = s.length();
		int output=0;
		char[] ch = s.toCharArray();
		if(leng>=2)
		{
			for(int i=0;i<leng-1;i++)
			{
				if(ch[i]=='I')
				{
					if(ch[i+1]=='V')  {output += 4;i++;continue;}
					if(ch[i+1]=='X')  {output += 9;i++;continue;}
					else output +=1;
				}
				if(ch[i]=='V') output += 5;
				if(ch[i]=='X')
				{
					if(ch[i+1]=='L') {output += 40;i++;continue;}
					if(ch[i+1]=='C') {output += 90;i++;continue;}
					else output += 10;
				}
				if(ch[i]=='L') output +=50;
				if(ch[i]=='C')
				{
					if(ch[i+1]=='D') {output += 400;i++;continue;}
					if(ch[i+1]=='M') {output += 900;i++;continue;}
					else output += 100;
				}
				if(ch[i]=='D') output +=500;
				if(ch[i]=='M') output +=1000;
			}
			

			if(ch[leng-1]=='I') output +=1;
			if(ch[leng-1]=='V'&&ch[leng-2]!='I') output +=5;
			if(ch[leng-1]=='X'&&ch[leng-2]!='I') output +=10;
			if(ch[leng-1]=='L'&&ch[leng-2]!='X') output +=50;
			if(ch[leng-1]=='C'&&ch[leng-2]!='X') output +=100;
			if(ch[leng-1]=='D'&&ch[leng-2]!='C') output +=500;
			if(ch[leng-1]=='M'&&ch[leng-2]!='C') output +=1000;
		}
		else
		{
			if(ch[leng-1]=='I') output +=1;
			if(ch[leng-1]=='V') output +=5;
			if(ch[leng-1]=='X') output +=10;
			if(ch[leng-1]=='L') output +=50;
			if(ch[leng-1]=='C') output +=100;
			if(ch[leng-1]=='D') output +=500;
			if(ch[leng-1]=='M') output +=1000;
		}
		  
		return output;     
	    }
	  /**************************����************************/
	 
	 /**************************����������ģ��************************/
    public static void main(String[] args)
    {
//    	boolean isok = isValid("(([]){})");     
//    	System.out.println(isok);//��֤����ƥ��
    	//int[] testarray= {0,0,1,1,1,2,2,3,3,4};
    	//System.out.println(removeDuplicates(testarray));
    	/*String s = "abcabc";
    	int a = lengthOfLongestSubstring(s);
    	System.out.println(a);*/
    	//System.out.println(isPalindrome(-232));
    	System.out.println(romanToInt("M"));
    	
    }
}
