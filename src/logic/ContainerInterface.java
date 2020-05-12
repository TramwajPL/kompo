package logic;

import java.util.ArrayList;

public interface ContainerInterface<T> {
	public void add(T t);
	public int size();
	public ArrayList<T> getAll();
	public T get(int index) throws TooLargeIndexException;
}
