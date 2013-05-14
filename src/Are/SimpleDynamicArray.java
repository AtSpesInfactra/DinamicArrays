package Are;

public class SimpleDynamicArray implements IDynamicArray {

	private int length;
	private Object[] array;

	public SimpleDynamicArray(int size, Object[] arr) {
		length = size;
		this.array = arr;
	}

	public void printOut() {
		if (length == 0)
			System.out.println("Simple is empty");
		System.out.println("dynamic array:");
		for (int i = 0; i < length; i++)
			System.out.println(array[i]);
		System.out.println("    ");
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		if (length == 0)
			return true;
		else
			return false;
	}

	public boolean contains(Object obj) {
		for (int i = 0; i < length; i++) {
			if (array[i].equals(obj)) {
				System.out.println("contains");
				return true;
			}
		}
		System.out.println("doesn't contain");
		return false;
	}

	public Object[] toArray() {
		return array;
	}

	public boolean add(Object a) {
		Object[] buf = new Object[this.length + 1];
		int i;
		for (i = 0; i < this.length; i++)
			buf[i] = this.array[i];

		buf[length] = a;
		length++;
		array = buf;

		if (array[length - 1] == null)
			return false;

		return true;

	}

	public boolean remove(Object o) {
		if (!this.contains(o))
			return false;
		Object[] buf = new Object[this.length - 1];
		int i;
		for (i = 0; i < length; i++) {
			if (this.array[i] == o)
				break;
			buf[i] = array[i];
		}

		for (int j = i; j < length - 1; j++) {
			buf[j] = array[j + 1];
		}
		array = buf;
		length--;
		return true;
	}

	public Object remove(int index) {
		if (index >= length)
			return null;
		Object buf = new Object();
		buf = array[index];
		this.remove(buf);
		return buf;
	}

	public void clear() {
		array = null;
		length = 0;
	}

	public Object get(int index) {
		return (array[index]);
	}

	public Object set(int index, Object element) {

		Object buf = array[index];
		array[index] = element;
		return buf;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < length; i++) {
			if (array[i] == o)
				return i;
		}
		return (-1);

	}

}
