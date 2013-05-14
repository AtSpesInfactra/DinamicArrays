package Are;

public class DynamicArraysTests {
	
	public static void main(String [] a){
		
		Human [] people = new Human[4];
		Human man0 = new Human(19,80, "Ushakov");
		people[0] = man0;
		Human man1 = new Human(93,50, "Ivanov");
		people[1] = man1;
		Human man2 = new Human(40,70, "Petrov");
		people[2] = man2;
		Human man3 = new Human(31,115, "Sidorov");
		people[3] = man3;
		
		SimpleDynamicArray simple = new SimpleDynamicArray( 4, people);
		LinkedDynamicArray list = new LinkedDynamicArray( people);
		
		System.out.println("Massives:");
		simple.printOut();
		list.printOut();
		
		//Let's create some objects to add/find
		Animal wolf = new Animal(9,60,"Wolf");
		Human medvedev = new Human(40,80,"D.A.M");
		
		//////
		System.out.println("Test for .contain");
		simple.contains(wolf);
		list.contains(new Human(19,80, "Ushakov"));//////////////////////////////
		System.out.println("  ");
		//////
		
		System.out.println("Test for .add");
		simple.add(wolf);
		simple.add(medvedev);
		simple.printOut();
		list.add(wolf);
		list.add(medvedev);
		list.printOut();
		System.out.println("    ");
		///////////
		
		System.out.println("Test for .size");
		System.out.println(simple.size());
		System.out.println(list.size());
		System.out.println("    ");
		///////////////
		
		System.out.println("Test for .set");
		simple.set(1, wolf);
		list.set(1, wolf);
		simple.printOut();
		list.printOut();
		System.out.println("    ");
		/////////
		
		System.out.println("Test for .index");
		System.out.println(simple.indexOf(man1));
		System.out.println(list.indexOf(man1));
		System.out.println("   ");
		////////////
		
		System.out.println("Test for .get");
		System.out.println(simple.get(5));
		System.out.println(list.get(5));
		System.out.println("    ");
		//////////
		
		
		System.out.println("Test for .toArray");
		Object [] bufSimple = new Object[simple.size()];
		Object [] bufList = new Object[simple.size()];
		bufSimple = simple.toArray();
		bufList = list.toArray();
		for (int i = 0; i< simple.size(); i++){
			System.out.println(bufSimple[i]);
		}
		System.out.println("    ");
		for (int i = 0; i< list.size(); i++){
			System.out.println(bufList[i]);
		}
		System.out.println("    ");
		///////////////
		
		System.out.println("Tests for .remove(both them)");
		System.out.println("Removed "+simple.remove(1));
		simple.remove(man3);
		simple.printOut();
		System.out.println("removed "+list.remove(1));
		list.remove(man3);
		list.printOut();
		System.out.println("    ");
		/////////////////
		
		
		System.out.println("Test for .clear");
		simple.clear();
		list.clear();
		simple.printOut();
		list.printOut();
		
	}

}
