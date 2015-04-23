
public class MainApp {

	public static void main(String[] args) {
		Tree tree = new Tree() ;
		
		tree.insertNode(32);
		tree.insertNode(51);
		tree.insertNode(20);
		tree.insertNode(31);
		tree.insertNode(41);
		tree.insertNode(62);
		tree.insertNode(37);
		tree.insertNode(45);
		tree.insertNode(38);
		tree.findKey(37);
/*		System.out.println(tree.getMinimum(tree.Root).Key);
		System.out.println(tree.getMaximum(tree.Root).Key);
*/		System.out.println();
		tree.inorderPrint(tree.Root);
		System.out.println();
		/*tree.postorderPrint(tree.Root);
		System.out.println();
		tree.preorderPrint( tree.Root);
		*/
		
		tree.Delete(tree, tree.findKey(51));
		tree.inorderPrint(tree.Root);
	}

}
