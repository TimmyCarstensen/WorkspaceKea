package boxGenerics;

public class BoxDemo4 {

	public static <U> void addBox(U u, java.util.List<Box<U>> boxes) {
		Box<U> box = new Box<U>();
	    box.add(u);
	    boxes.add(box);
	}

	public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
		int counter = 0;
		for (Box<U> box: boxes) {
			U boxContents = box.get();
			System.out.println(
					"Box #" + counter + " contains [" +
					boxContents.toString() + "]");
			counter++;
		}
	}

	public static void main(String[] args) {
		java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<Box<Integer>>();
		BoxDemo4.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
		BoxDemo4.addBox(Integer.valueOf(20), listOfIntegerBoxes);
		BoxDemo4.addBox(Integer.valueOf(30), listOfIntegerBoxes);
		BoxDemo4.outputBoxes(listOfIntegerBoxes);
	}
}