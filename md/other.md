###�Զ�����
[Integer].intValue();  // ��װ��ת ��������
Integral.toString(int ) �� [Integral].toString()  //����ת <�ַ�����
Integer.parseInt(str); //�ַ��� ת < ���� >
Integral.valueOf(str)  //�ַ���/���� ת< ��װ�� >
NumberFormatException


String.valueOf()  ��������ת�ַ��� �ڲ�ʵ����ʵҲ�ǵ��� Integral.toString()

#### list
List<String> l = new ArrayList<String>(Arrays.asList([string])) 
Collection.toArray(new String[0]);
list.subList(start,end)
Collection.sort()

Collection.synchronizedList
Collection.synchronizedSet
           synchronized

Comparable com������
Comparator com�����
deque
peek

poll offer

####map
LinkedHashMap()
map.keySet();
map.entrySet(); Entry(String, Integer)
map.values()
map.containsKey
map.containValue

##ref
void write(int d) writeInt()
long getFilePointer() ref.seek(0);
int read() -1

void write(byte[] byte)
int read(byte[] byte)  ʵ�ʵ��ֽ��� �������ֽ�

raf.length()

####IO
fileInputStream(path, append)
fileOutputStream(path, append)

ObjectInputStream  ���������� readObject()�� //�������� serialVersionUID
ObjectOutputStream �������л� writeObject() //Serializable  ���� transient

BufferedInputStream(fos); ���д
BufferedOutputStream(fos); ���� ����

//ת����
InputStreamReader(fis, "UTF-8")    int read(char[]) �ַ���
OutputStreamWriter(fis, "UTF-8")  write(string)

BufferedReader()     �����ַ���    readLine
BufferedWriter()     �����ַ���


printWrite(path, "UTF-8") println
```java
public PrintWriter(String fileName) throws FileNotFoundException {
    this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))),
    false);
}
```

### reflect �����
newInstance ʵ���� 9out

method.invoke(o, null);

����.class
Class.forName(string)


###lambdael


## 
thread runnable 
Thread.currentThread
thread.join()
thread.sleep(1000)
thread.interrupt(); �ж�����״̬
synchronized
synchromized(ͬһ�� ͬ������������){
    ��Ҫͬ�����еĴ���Ƭ��
}
��̬���� ͬ��������Ϊ�����

### threadpool
ExecutorService threadPool = Executors.newFixedThreadPool(2);
threadPool.execute(Runnable);
threadPool.shutdown();
threadPool.shutdownNow();

###

###date


###socket