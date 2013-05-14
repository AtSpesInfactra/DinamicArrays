package Are;

public class LinkedDynamicArray implements IDynamicArray {

	private ListObject head;
	private int length;

	private class ListObject {
		Object item;
		ListObject next;
		ListObject prev;

		ListObject(ListObject prev, Object element, ListObject next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

	public void printOut() {
		System.out.println("List:");
		if (length > 0) {
			ListObject buf = new ListObject(head.prev, head.item, head.next);
			for (int i = 0; i < length; i++) {
				System.out.println(buf.item);
				buf = buf.next;
			}
			System.out.println("    ");
		} else {
			System.out.println("List if empty");
			return;
		}
	}

	public LinkedDynamicArray(Object[] array) {
		this.length = array.length;
		ListObject[] list = new ListObject[length];

		for (int i = 0; i < length; i++) {
			list[i] = new ListObject(null, "safs", null);
		}

		list[0].prev = list[0];
		list[0].item = array[0];
		list[0].next = list[1];

		for (int i = 1; i < length - 1; i++) {
			list[i].prev = list[i - 1];
			list[i].item = array[i];
			list[i].next = list[i + 1];
		}

		list[length - 1].prev = list[length - 2];
		list[length - 1].item = array[length - 1];
		list[length - 1].next = list[length - 1];

		head = list[0];
	}

	private Object deleteNode(ListObject hee) { // head - не this.head
		ListObject buf = new ListObject(hee.prev, hee.item, hee.next);

		if ((!(hee.prev.equals(hee))) & (!(hee.next.equals(hee)))) {
			hee.prev.next = hee.next;
			hee.next.prev = hee.prev;
		}

		if (hee.prev.equals(hee)) {
			this.head = this.head.next;
			this.head.prev = this.head;
			;
		}

		if (hee.next.equals(hee)) {
			hee = hee.prev;
			hee.next = hee;
		}
		length--;
		return buf.item;

	}

	// ///////////////////////

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		if (this.size() == 0)
			return true;
		else
			return false;
	}

	public boolean contains(Object obj) {
		ListObject runner = new ListObject(head.prev, head.item, head.next);

		do {
			if (runner.item.equals(obj)) {
				System.out.println("Linked contains");
				return true;
			}
			runner = runner.next;

			if (runner.item.equals(obj)) {
				System.out.println("Linked contains");
				return true;
			}
			runner = runner.next;
		} while (!runner.next.equals(runner));

		System.out.println("Linked doesn't contain");
		return false;
	}

	public Object[] toArray() {
		ListObject runner = new ListObject(head.prev, head.item, head.next);
		Object[] buf = new Object[length];
		for (int i = 0; i < length; i++) {
			buf[i] = runner.item;
			runner = runner.next;
		}
		return buf;
	}

	public boolean add(Object a) {
		ListObject runner = new ListObject(head.prev, head.item, head.next);

		do {
			runner = runner.next;
		} while (!runner.next.equals(runner));

		ListObject buf = new ListObject(runner, a, runner);
		buf.next = buf;
		runner.next = buf;
		buf.prev = runner;

		length++;
		return true;
	}

	public boolean remove(Object o) {
		if (!this.contains(o))
			return false;

		ListObject runner = new ListObject(head.prev, head.item, head.next);

		for (int i = 0; i < length; i++) {
			if (runner.item.equals(o)) {
				this.deleteNode(runner);
				return true;
			}
			runner = runner.next;
		}
		return false;
	}

	public Object remove(int index) {
		if (index >= length)
			return null;
		ListObject runner = new ListObject(head.prev, head.item, head.next);
		for (int i = 0; i < index; i++) {
			runner = runner.next;
		}
		// ////
		Object buf = new Object();
		buf = runner.item;

		if (runner.prev.equals(runner)) {
			System.out.println("REMOVING HEAD ");
			runner.next.prev = runner.next;
			head = runner.next;
			length--;
			return buf;
		}

		if (runner.next.equals(runner)) {
			System.out.println("REMOVING END    ");
			runner = runner.prev;
			runner.next = runner;
			length--;
			return buf;
		}

		runner.next.prev = runner.prev;
		runner.prev.next = runner.next;
		length--;
		return buf;

		// return(this.deleteNode(runner));
	}

	public void clear() {
		length = 0;
		head = null;
	}

	public Object get(int index) {
		ListObject runner = new ListObject(head.prev, head.item, head.next);
		for (int i = 0; i < index; i++)
			runner = runner.next;

		return (runner.item);
	}

	public Object set(int index, Object element) {

		ListObject runner = new ListObject(head.prev, head.item, head.next);
		for (int i = 0; i < index; i++)
			runner = runner.next;

		Object toGive = new Object();
		toGive = runner.item;

		runner.item = element;

		return (toGive);
	}

	public int indexOf(Object o) {
		ListObject runner = new ListObject(head.prev, head.item, head.next);
		for (int i = 0; i < length; i++) {

			if (runner.item.equals(o))
				return i;

			runner = runner.next;
		}

		return (-1);

	}

}
