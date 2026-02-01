public class Main {	
	
	public static void main(String[] args) {
	    Queue<Integer> q1 = new Queue<Integer>();
        q1.insert(2);
        q1.insert(2);
        q1.insert(6);
        q1.insert(9);
        q1.insert(10);
        
        
        Queue<Integer> q2 = new Queue<Integer>();
        q2.insert(1);
        q2.insert(2);
        q2.insert(3);
        q2.insert(7);
        q2.insert(9);
        
        
        Queue<String> q3 = new Queue<String> ();
        q3.insert("abc");
        q3.insert("2");
        q3.insert("22");
        q3.insert("a");
        q3.insert("b");
        
        
        

    //    System.out.println(delRepeat(q1).toString());
    //    System.out.println((merge(q1,q2)).toString());
    //    System.out.println(isRepeat(q3));
    //    System.out.println(delX(q2, 9).toString());

        Queue<Integer> q4 = new Queue<Integer>();
        q4.insert(1);
        q4.insert(6);
        q4.insert(3);
        q4.insert(2);
        q4.insert(2);
        q4.insert(9);
        System.out.println(sort(q4).toString());

                
	}
	
	
	
	//כתבו פעולה המקבלת תור של תווים ומחזירה תור שלמים שהם גדלי הרצפים בקלט.
//לדוגמה עבור [c,c,a,c] יוחזר [2,1,1].  מה גודל הקלט ומה הסיבוכיות?

	public static Queue<Integer> countSeq(Queue<Character> q)
	{
	    Queue<Integer> result = new Queue<Integer> ();
	    Queue<Character> temp = copyQueue(q);
	    char x = temp.remove();
	    int count = 1;
	    while(!temp.isEmpty())
	    {
	        count = 1;
	        boolean same = true;
	        
	        while(!temp.isEmpty() && same)
	        {
	            char y = temp.remove();
	            
	            if(x!=y)
	            {
	                same = false;
	                x = y;
	            }
	            else
	            {
	                count ++;
	            }
	        }
	       result.insert(count);
	        
	    }
	    if(count == 1)
	    {
	        result.insert(count);

	    }
	    return result;
	}
	
	//כתבו פעולה חיצונית המקבלת שני תורים ממוינים בסדר עולה, וממזגת אותם לתור חדש ממוין.

	public static Queue<Integer> merge(Queue<Integer> q1,Queue<Integer> q2)
	{
	    
	    Queue<Integer> q1Temp = copyQueue(q1);
	    Queue<Integer> q2Temp = copyQueue(q2);
	    Queue<Integer> merged = new Queue<Integer> ();
	    int elem1 = q1Temp.remove();
	    int elem2 = q2Temp.remove();
	    boolean finish1 = false;
	    boolean finish2 = false;
	    while(!finish1 || !finish2)
	    {
	        if(finish1){
	            while(!q2Temp.isEmpty()) {
	                merged.insert(q2Temp.remove());
	            }
	            finish2 = true;
	        }
	        if(finish2){
	            while(!q1Temp.isEmpty()) {
	                merged.insert(q1Temp.remove());
	            }
	            finish1 = true;
	        }
	        else if(elem1<elem2)
	        {
	            merged.insert(elem1);
	            if(!q1Temp.isEmpty())
	            {
	                elem1= q1Temp.remove();
	            } 
	            else {
	               finish1 = true; 
	            }
	        }
	        else
	        {
	            merged.insert(elem2);
	            if(!q2Temp.isEmpty()){
	                elem2= q2Temp.remove();
	            } 
	            else {
	                finish2 = true; 
	            }
	            
	        }
	    }
	    return merged;
	}
	
	public static boolean isRepeat(Queue<String> q)
	{
	    Queue<String> q1 = copyQueue(q);
	    while(!q1.isEmpty())
	    {
	       String x = q1.remove();
	       if(isIn(q1,x))
	       {
	           return true;
	       }
	    }
	    return false;
	}
	
	public static <T> boolean isIn(Queue<T> q, T x) {
		boolean r = false;
		Queue<T> save = new Queue<T>();
		while (!q.isEmpty()) {
			T a = q.remove();
			save.insert(a);
			if (a.equals(x))
				r = true;
		}
		while (!save.isEmpty()) {
			q.insert(save.remove());
		}
		return r;
	}
	
	
	
	 public static <T> Queue<T> delX(Queue<T> q, T x)
    {
        Queue<T> temp = copyQueue(q);
        Queue<T> result = new Queue<T> ();
        while(!temp.isEmpty())
        {
            T y = temp.remove();
            if(x!= y)
            {
                result.insert(y);
            }
        }
        
        return result;
    }
	
	

	public static <T> Queue<T> copyQueue(Queue<T> q)
    {
        Queue<T> temp = new Queue<T>();
        Queue<T> copy = new Queue<T>();
    
        while (!q.isEmpty())
        {
            T x = q.remove();
            temp.insert(x);
            copy.insert(x);
        }
    
        while (!temp.isEmpty())
            q.insert(temp.remove());
    
        return copy;
    }
    
    
    public static <T> Queue <T> delRepeat(Queue<T> q)
    {
        Queue<T> temp = copyQueue(q);
        Queue<T> result = new Queue<T>();       
        while(!temp.isEmpty())
        {
            T x = temp.remove();
            if(!isIn(temp,x))
            {
                result.insert(x);
            }
        }
        
        return result;
    }
    
    public static Queue<Integer> sort(Queue<Integer> q)
    {
        Queue<Integer> temp = copyQueue(q);
        Queue<Integer> result = new Queue<Integer>();  
        
        while(!temp.isEmpty())
        {
            int x = min(temp);
            result.insert(x);
            temp = delX(temp, x);
        } 
        return result;
    }
    
    public static int min(Queue<Integer> q)
    {
        Queue<Integer> temp = copyQueue(q);
        int min=9999;
        while(!temp.isEmpty())
        {
            int x = temp.remove();
            if(x < min) {
                min = x;
            }
        }
        return min;
    }
	
}