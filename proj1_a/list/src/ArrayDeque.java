public class ArrayDeque<T> {
    private T[] array;
    private int frontPtr;
    private int backPtr;
    private int size;
    private int capacity;
    public ArrayDeque()
    {
        array=(T[]) new Object[8];
        capacity=8;
        frontPtr=0;
        backPtr=0;
        size=0;
    }
    public ArrayDeque(T p)
    {
        array=(T[]) new Object[8];
        capacity=8;
        array[frontPtr]=p;
        frontPtr=0;
        backPtr+=1;
        size+=1;
    }

    private boolean isFull()
    {
        return (backPtr)%capacity==frontPtr&&size==capacity;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    private void updata()
    {
        if(isFull())
        {
            resize(capacity*2);
        }
        else
        {
            minsize(size);
        }
    }

    private void resize(int newCapacity)
    {
        T[] newArray=(T[]) new Object[newCapacity];
        for(int i=0;i<size;i++)
        {
            newArray[i]=array[i];
        }
        array=newArray;
        capacity*=2;
        size=capacity;
    }

    private void minsize(int newCapacity)
    {
        T[] Arraylist=(T[])new Object[newCapacity];
        for(int i=0;i<newCapacity;i++)
        {
            Arraylist[i]=array[i];
        }
        array=Arraylist;
        capacity=newCapacity;
        size=newCapacity;
        backPtr=size;
    }
    public void addFirst(T data)
    {
        if(isFull())
        {
            updata();
        }
        for(int i=size;i>0;i--)
        {
            array[i]=array[i-1];
        }
        array[frontPtr]=data;
        size+=1;
    }

    public void addLast(T data)
    {
        if(isFull())
        {
            updata();
        }
        array[backPtr]=data;
        backPtr+=1;
        size+=1;
    }
    public int size()
    {
        return size;
    }
    public void Printdeque()
    {
        for(int i=0;i<size;i++)
        {
            System.out.println(array[i]);
            System.out.println(" ");
        }
    }

    public T removeFirst()
    {
        T temp=array[frontPtr];
        if(size==1)
        {
            array[frontPtr]=null;
            size-=1;
            backPtr-=1;
            return temp;
        }
        for(int i=0;i<size-1;i++)
        {
            array[i]=array[i+1];
        }
        backPtr-=1;
        size-=1;
        return temp;
    }

    public T removeLast()
    {
        if(isEmpty())
        {
            return null;
        }
        else{
            size-=1;
            return array[backPtr-1];
        }
    }

    public T get(int index)
    {
        if(index<0||index>size)
        {
            return null;
        }
        return array[index-1];
    }
}

