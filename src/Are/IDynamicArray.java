package Are;

public interface IDynamicArray {
	int size();
	boolean isEmpty();
	boolean contains(Object o);
	Object[] toArray();
	boolean add(Object e);
	boolean remove(Object o);
	Object remove(int index);
	void clear();
	Object get(int index);
	Object set(int index, Object element);
	int indexOf(Object o);
}
