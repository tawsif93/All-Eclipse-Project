
public class Tree {

	public Node Root ;
	
	public Tree (){
		Root = null ;		
	}
	
	
	
	
	public Node getMinimum(Node root) {
		if(root == null) System.out.println("Tree Empty");
		
		Node currentNode = root ;
		
		Node minimum = null ; 
				
		while (currentNode != null)
		{
			
			minimum = currentNode ;
			currentNode = currentNode.LeftChild ;
			
		}
		
		return minimum;
	}
	
	
	public Node getMaximum(Node root) {
		if(root == null) System.out.println("Tree Empty");
		
		Node currentNode = root ;
		
		Node maximum = null ; 
				
		while (currentNode != null)
		{
			
			maximum = currentNode ;
			currentNode = currentNode.RightChild ;
			
		}
		
		return maximum;
	}
	
	public Node findKey(int key) {
		if(Root == null) System.out.println("Tree Empty");
		
		Node currentNode = Root ;
		
		while(currentNode != null)
		{
			if(currentNode.Key == key ) 
			{
				System.out.println("" + key + " found ");
				return currentNode;
			}
			
			else if(currentNode.Key > key) 
			{
				currentNode = currentNode.LeftChild ;
				
			}
			
			else if (currentNode.Key < key)
			{
				currentNode = currentNode.RightChild ;
			}
			
			if(currentNode == null)  System.out.println("Not Found");
		}
		return currentNode;
	}
	
	public void insertNode(int key)
	{
		if(Root == null) 
		{
			Root = new Node(key);
			return ;
		}
		
		 Node parent = null ;
		 Node currentNode = Root ;
		 
		 while(true)
		 {
			 parent = currentNode ;
			 
			 if(currentNode.Key > key) 
			 {
				 currentNode = currentNode.LeftChild ;
				 if(currentNode == null) 		
				 {
					 System.out.println(parent.Key +  " Left " + key);
					 parent.LeftChild = new Node(key) ;
					 parent.LeftChild.Parent = parent ;
					 return ;
				 }
			 }
			 
			 else if(currentNode.Key < key ) 
			 {
				 currentNode = currentNode.RightChild ;
				 if(currentNode == null) 
				 {
					 System.out.println(parent.Key + " rigth " +key);
					 parent.RightChild = new Node(key);
					 parent.RightChild.Parent = parent ;
					 return ;
				 }
			 }
		 }
	}

	public void transplant(Tree tree , Node u , Node v)
	{
		if(u.Parent == null)
		{
			tree.Root = v ;
		}
		
		else if (u.Parent.LeftChild == u)
		{
			u.Parent.LeftChild = v ;
		}
		else u.Parent.RightChild = v ;
		
		if(v != null)
		{
			v.Parent = u.Parent ;
		}
	}
	
	public void Delete (Tree tree , Node z)
	{
		if(z.LeftChild == null) 
		{
			transplant(tree, z, z.RightChild);
		}
		
		else if( z.RightChild == null)
		{
			transplant(tree, z, z.LeftChild);
		}
		
		else 
		{
			Node y = tree.getMinimum(z.RightChild);
			
			if(y.Parent != z)
			{
				transplant(tree, y	, y.RightChild);
				y.RightChild= z.RightChild ;
				y.RightChild.Parent = y ;
				
			}
			
			transplant(tree, z, y);
			y.LeftChild = z.LeftChild ;
			y.LeftChild.Parent= y ;
		}
		
	}
	
	public void preorderPrint(Node tree) {
	     if (tree == null) return; 
	     System.out.println(tree.Key);
	     inorderPrint(tree.LeftChild);
	     inorderPrint(tree.RightChild);
	}

	
	public void inorderPrint(Node tree) {
	     if (tree == null) return; 
	     inorderPrint(tree.LeftChild);
	     System.out.println(tree.Key);
	     inorderPrint(tree.RightChild);
	}
	
	public void postorderPrint(Node treeNode ) {
	     if (treeNode == null) return; 
	     inorderPrint(treeNode.LeftChild);
	     inorderPrint(treeNode.RightChild);
	     System.out.println(treeNode.Key);
	}

}
