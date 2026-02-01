import java.util.*;

class Main {

	public static void main1(String[] args) {
	    
		BinNode<Integer> t4 = new BinNode<Integer>(4);
		BinNode<Integer> t5 = new BinNode<Integer>(5);
		BinNode<Integer> t6 = new BinNode<Integer>(6);
		BinNode<Integer> t7 = new BinNode<Integer>(7);
		
		BinNode<Integer> t2 = new BinNode<Integer>(t4, 2, t5);
		BinNode<Integer> t3 = new BinNode<Integer>(t6, 3, t7);
		BinNode<Integer> t1 = new BinNode<Integer>(t2, 1, t3);
		
		//System.out.println(printByLevel4(t1));
		//printByLevel5(t1);
		printByLevel5(t1);
	}
	
	public static void main(String[] args) {
	    
		BinNode<Integer> t4 = new BinNode<Integer>(5);
		BinNode<Integer> t5 = new BinNode<Integer>(9);
		BinNode<Integer> t6 = new BinNode<Integer>(15);
		BinNode<Integer> t7 = new BinNode<Integer>(25);
		t7.setRight(new BinNode<Integer>(30));
		
		BinNode<Integer> t2 = new BinNode<Integer>(t4, 7, t5);
		BinNode<Integer> t3 = new BinNode<Integer>(t6, 20, t7);
		BinNode<Integer> t1 = new BinNode<Integer>(t2, 10, t3);
		
		
		BinNode<Integer> t61 = new BinNode<Integer>(10);
		BinNode<Integer> t62 = new BinNode<Integer>(75);
		BinNode<Integer> t10 = new BinNode<Integer>(t61, 20, t62);
		//System.out.println(hezyon(t1));
		//System.out.println(checkNearestParent(t1 ,30, 15 ));
		//System.out.println(dividBy2Not3(t1));
		//System.out.println(dividBy2(t1));
		System.out.println(ex18(t1,t10 ));
	
	}
	
	public static void main3(String[] args) {
	    
		BinNode<Double> t4 = new BinNode<Double>(5.0);
		BinNode<Double> t5 = new BinNode<Double>(9.0);
		BinNode<Double> t6 = new BinNode<Double>(15.0);
		BinNode<Double> t7 = new BinNode<Double>(25.0);
		t7.setRight(new BinNode<Double>(30.0));
		
		BinNode<Double> t2 = new BinNode<Double>(t4, 7.0, t5);
		BinNode<Double> t3 = new BinNode<Double>(t6, 20.0, t7);
		BinNode<Double> t1 = new BinNode<Double>(t2, 10.0, t3);
		
		//System.out.println(hezyon(t1));
		//System.out.println(checkNearestParent(t1 ,30, 15 ));
		//System.out.println(dividBy2Not3(t1));
		//System.out.println(dividBy2(t1));
		
		System.out.println(ex16(t1));
	}
	
	
	public static <T> int ex14(BinNode<T> t)
	{
	    if(t==null)
	    {
	        return 0;
	    }
	    
	    if(!t.hasLeft() && !t.hasRight())
	    {
	        return 1;
	    }
	    
	    int left = ex14(t.getLeft ());
	    int right = ex14(t.getRight());
	    return left+right;
	    
	    
	}
	
	public static Double ex16(BinNode<Double> t)
	{
	    if(t==null)
	    {
	        return 0.0;
	    }
	   
	    Double left = ex16(t.getLeft());
	    Double right = ex16(t.getRight());
	    Double current = 0.0;
	    if(t.hasLeft() && t.hasRight())
	    {
            current =  t.getValue();
	        
	    }
	    return left+right+current;
	}
	public static boolean isExist(BinNode<Integer> t, int x)
	{
	    if(t==null)
	    {
	        return false;
	    }
	    
	    if(x==t.getValue())
	    {
	        return true;
	    }
	    return isExist(t.getRight(),x) || isExist(t.getLeft(),x);
	    
	}
	
	public static boolean ex18(BinNode<Integer> t1, BinNode<Integer> t2)
	{
	    if(t2==null)
	    {
	       return true;
	    }
	    
	    boolean left = ex18(t1, t2.getLeft());
	    boolean right = ex18(t1, t2.getRight());
	    boolean current = isExist(t1, t2.getValue());
	    
	    if(current && left && right)
	    {
	       return true; 
	    }
	    return false;
	}
	

    public static <T> void printByLevel(BinNode<T> root) 
    {
        if (root == null)
            return;

        Queue<BinNode<T>> queue = new Queue<BinNode<T>>();
        queue.insert(root);

        while (!queue.isEmpty()) {
            BinNode<T> current = queue.remove();
            
            System.out.print(current.getValue() + " ");

            if (current.hasLeft()){
                queue.insert(current.getLeft());
            }

            if (current.hasRight()){
                queue.insert(current.getRight());
            }
            
  
        }
    }
    
     public static <T> void printByLevel2(BinNode<T> root) {
        if (root == null)
            return;
    
        Queue<BinNode<T>> currentLevel = new Queue<>();
        Queue<BinNode<T>> nextLevel = new Queue<>();
    
        currentLevel.insert(root);
    
        while (!currentLevel.isEmpty()) {
            BinNode<T> current = currentLevel.remove();
            System.out.print(current.getValue() + " ");
    
            if (current.hasLeft())
                nextLevel.insert(current.getLeft());
    
            if (current.hasRight())
                nextLevel.insert(current.getRight());
    
            // אם סיימנו רמה
            if (currentLevel.isEmpty()) {
                System.out.println();
                // החלפת התורים
                Queue<BinNode<T>> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

	
	public static <T> void printByLevel3(BinNode<T> root) 
    {
        if (root == null)
            return;

        Queue<BinNode<T>> queue = new Queue<BinNode<T>>();
        queue.insert(root);

        while (!queue.isEmpty()) {
            BinNode<T> current = queue.remove();
            
            System.out.print(current.getValue() + " ");

            if (current.hasRight()){
                queue.insert(current.getRight());
            }
            
        }
    }
    
    public static <T> Node<BinNode<T>> printByLevel4(BinNode<T> root) 
    {
        if (root == null)
            return null;

        Queue<BinNode<T>> queue = new Queue<BinNode<T>>();
        queue.insert(root);
        Node<BinNode<T>> p = new Node<BinNode<T>>(root);
        Node<BinNode<T>> head = p;
        //point.setNext(new Node<BinNode<T>>());

        while (!queue.isEmpty()) {
            BinNode<T> current = queue.remove();
            
            //System.out.print(current.getValue() + " ");

            if (current.hasRight()){
                queue.insert(current.getRight());
                Node<BinNode<T>> temp = new Node<BinNode<T>>(current.getRight());
                p.setNext(temp);
                p = p.getNext();
            }
            
        }
        return head;
    }
    

     public static <T> void printByLevel5(BinNode<T> root) {
        if (root == null)
            return;
    
        Queue<BinNode<T>> currentLevel = new Queue<>();
        Queue<BinNode<T>> currentLevelReverse = new Queue<>();
        
        Queue<BinNode<T>> nextLevel = new Queue<>();
        Queue<BinNode<T>> nextLevelReverse = new Queue<>();
        
        currentLevel.insert(root);
        currentLevelReverse.insert(root);
        int level = 0;
        
        while (!currentLevel.isEmpty()) {
            BinNode<T> current = currentLevel.remove();
            BinNode<T> currentReverse = currentLevelReverse.remove();
            if(level % 2 == 0)
                System.out.print(current.getValue() + " ");
            else                
                System.out.print(currentReverse.getValue() + " ");
    
            if (current.hasLeft())
                nextLevel.insert(current.getLeft());
            if (current.hasRight())
                nextLevel.insert(current.getRight());
            
            if (currentReverse.hasRight())
                nextLevelReverse.insert(currentReverse.getRight()); 
            if (currentReverse.hasLeft())
                nextLevelReverse.insert(currentReverse.getLeft());
               
    
            // אם סיימנו רמה
            if (currentLevel.isEmpty()) {
                System.out.println();
                // החלפת התורים
                Queue<BinNode<T>> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                
                Queue<BinNode<T>> tempReverse = currentLevelReverse;
                currentLevelReverse = nextLevelReverse;
                nextLevelReverse = tempReverse;
                level++;
            }
        }
    }



	/* Construct from in-order with brackets */
	public static BinNode<Integer> fromString(String s) {
		StringTokenizer tokenizer = new StringTokenizer(s);
		return fromString(tokenizer);
	}
	
	

	/* Construct from in-order with brackets */
	public static BinNode<Integer> fromString(StringTokenizer tokenizer) {
		if (!tokenizer.hasMoreElements())
			return null;
		String s = tokenizer.nextToken();
		if (s.equals("null"))
			return null;
		if (s.equals("(")) {
			BinNode<Integer> left = fromString(tokenizer);
			s = tokenizer.nextToken();
			Integer value = Integer.valueOf(s);
			BinNode<Integer> right = fromString(tokenizer);
			s = tokenizer.nextToken();
			if (!s.equals(")"))
				System.out.println("Note: missing ')'");
			return new BinNode<Integer>(left, value, right);
		}
		return new BinNode<Integer>(Integer.valueOf(s));
	}

	/*
	 * Type 1: Tree Scan
	 */
	public static void preOrder(BinNode<Integer> t) {
		if (t != null) {
			System.out.println(t.getValue());
			preOrder(t.getLeft());
			preOrder(t.getRight());
		}
	}

	/*
	 * Type 1: Tree Scan (generic method)
	 */
	public static <T> void inOrder(BinNode<T> t) {
		if (t != null) {
			inOrder(t.getLeft());
			System.out.println(t.getValue());
			inOrder(t.getRight());
		}
	}

	/*
	 * Type 3: Is there a node that meet a condition?
	 */
	public static boolean existsValue(BinNode<Integer> t, int x) {
		if (t == null)
			return false;

		if (t.getValue() == x)
			return true;

		boolean left = existsValue(t.getLeft(), x);

		boolean right = existsValue(t.getRight(), x);

		return left || right;
	}

	/*
	 * Type 4: Do all nodes meet a condition?
	 */
	public static boolean eachHasTwoChildren(BinNode<Integer> t) {

		// leaf node
		if (!t.hasLeft() && !t.hasRight())
			return true;

		// only one child
		if (!t.hasRight() || !t.hasLeft())
			return false;

		return eachHasTwoChildren(t.getLeft()) && eachHasTwoChildren(t.getRight());
	}
	
	
	/*
	 * Type 2: Count
	 */
	public static int countLeaves(BinNode<Integer> t) {
		if (t == null)
			return 0;
		if (!t.hasLeft() && !t.hasRight())
			return 1;
		return countLeaves(t.getLeft()) + countLeaves(t.getRight());
	}

	/*
	 * Type 2a: Sum
	 */
	public static int sumPos(BinNode<Integer> t) {
		if (t == null)
			return 0;

		int a = 0;

		if (t.getValue() > 0)
			a = t.getValue();

		return a + sumPos(t.getLeft()) + sumPos(t.getRight());
	}

	/*
	 * Type 1: Tree Scan
	 */
	public static void printEven(BinNode<Integer> t) {

		if (t != null) {

			printEven(t.getLeft());

			int value = t.getValue();

			if (value % 2 == 0)
				System.out.println(value);

			printEven(t.getRight());
		}
	}

    public static int countNodes(BinNode<Integer> t) {
        if (t == null)
			return 0;

		int left = countNodes(t.getLeft());

		int right = countNodes(t.getRight());

		return 1 + left + right;
    }
	/*
	 * Type 2: Count
	 */
	public static int countNodesAbove(BinNode<Integer> t, int saf) {
		if (t == null)
			return 0;

		int left = countNodesAbove(t.getLeft(), saf);

		int right = countNodesAbove(t.getRight(), saf);

		int current = 0;
		if (t.getValue() > saf)
			current = 1;

		return current + left + right;
	}
	
	public static int checkNearestParent(BinNode<Integer> root, int x, int y) {
	    Queue<BinNode<Integer>> parentX = findParents(root, x);
	    Queue<BinNode<Integer>> parentY = findParents(root, y);
	    int parent = -1; 
	    while (!parentX.isEmpty() && !parentY.isEmpty()) {
	        BinNode<Integer> intParentX = parentX.remove();
	        BinNode<Integer> intParentY = parentY.remove();
	        
	        if(intParentX.getValue() == intParentY.getValue()) {
	            parent = intParentX.getValue();
	        }
	    }
	    return parent;
	}
	
	public static Queue<BinNode<Integer>> findParents(BinNode<Integer> root, int x) {
	 
	    Queue<BinNode<Integer>> parentX = new Queue<BinNode<Integer>>();
	    
	    BinNode<Integer> p = root;
	     while(p != null){
	         if(p.getValue() < x) {
	             parentX.insert(p);
	             p = p.getRight();
	         } else if(p.getValue() > x) {
	             parentX.insert(p);
	             p = p.getLeft();
	         } else {
	             return parentX;
	         }
	     }
	     
	     return parentX;
	}


    public static double hezyon(BinNode<Integer> root) {
        
        if (root == null)
            return 0.0;

        Queue<BinNode<Integer>> queue = new Queue<BinNode<Integer>>();
        queue.insert(root);

        int treeSize = countNodes(root);
        while (!queue.isEmpty()) {
            BinNode<Integer> current = queue.remove();
            
            int above = countNodesAbove(root, current.getValue());
            int below = (treeSize -above) - 1;
            if(above == below) {
                return (double) current.getValue();
            } else if(below + 1 == above) {
                return (double) (current.getValue() + current.getRight().getValue()) / 2;
            } else if (above + 1 == below){
                return (double) (current.getValue() + current.getLeft().getValue()) / 2;
            }
            

            if (current.hasLeft()){
                queue.insert(current.getLeft());
            }

            if (current.hasRight()){
                queue.insert(current.getRight());
            }
        }
        
        return 0.0;
    }
    
    public static int dividBy2Not3(BinNode<Integer> root)
    {
        if(root == null)
        {
            return 0;
        }
        
        int left = dividBy2Not3(root.getLeft());
        int right = dividBy2Not3(root.getRight());
        
        int result = left + right;
        if((root.getValue() %2==0 ) && ( root.getValue()%3!=0))
        {
            result += 1;
        }
        return result;

    }
    
    public static boolean dividBy2(BinNode<Integer> root)
    {
        if(root == null)
        {
            return false;
        }
        
        boolean left = dividBy2(root.getLeft());
        boolean right = dividBy2(root.getRight());
        
        boolean result = left || right;
        if(root.getValue() %2==0)
        {
            result = true;
        }
        return result;

    }
    
    public static boolean checkSumChildrenEven(BinNode<Integer> root)
    {
        if(root == null)
        {
            return true;
        }
        
        if(root.getLeft() == null && root.getRight() == null) {
            return true;
        }
        if(root.getLeft() == null|| root.getRight() == null) {
            return false;
        }
        
        boolean left = checkSumChildrenEven(root.getLeft());
        boolean right = checkSumChildrenEven(root.getRight());
        
        
        if((root.getLeft().getValue() + root.getRight().getValue() ) %2 ==0) {
            return true;
        }
        else{
           return false; 
        }

    }
    
    public static void ex1(BinNode<Integer> t) 
{
    if (t == null) 
      return;

    if (t.getValue() % 2 == 0 &&
        (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
        (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
    {
        System.out.println(t.getValue());
    }

    ex1(t.getLeft());
    ex1(t.getRight());
}

public static int ex2(BinNode<Integer> t) 
{
    if (t == null) 
      return 0;

    int count = 0;
    if (t.getValue() % 2 == 0 &&
        (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
        (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
    {
        count = 1;
    }
    return count + ex2(t.getLeft()) + ex2(t.getRight());
}

public static boolean ex3(BinNode<Integer> t) 
{
    if (t == null) 
      return false;

    if (t.getValue() % 2 == 0 &&
        (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
        (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
    {
        return true;
    }
    return ex3(t.getLeft()) || ex3(t.getRight());
}

public static boolean ex4(BinNode<Integer> t) 
{
    if (t == null) 
      return true;

    if (t.getValue() % 2 == 0 &&
       ((t.hasLeft() && t.getLeft().getValue() % 2 != 0) ||
        (t.hasRight() && t.getRight().getValue() % 2 != 0))) 
    {
        return false;
    }
    return ex4(t.getLeft()) && ex4(t.getRight());
}


    public static int height(BinNode<Integer> root)
    {
    if (root == null)
        return -1;

    int leftHeight = height(root.getLeft());
    int rightHeight = height(root.getRight());

    if (leftHeight > rightHeight)
        return leftHeight + 1;
    else
        return rightHeight + 1;
    }
    
    

}
