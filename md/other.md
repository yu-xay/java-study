###自动拆箱
[Integer].intValue();  // 包装类转 《基本》
Integral.toString(int ) 或 [Integral].toString()  //基本转 <字符串》
Integer.parseInt(str); //字符串 转 < 基本 >
Integral.valueOf(str)  //字符串/基本 转< 包装类 >



String.valueOf()  其他类型转字符串 内部实现其实也是调用 Integral.toString()

#### list
List<String> l = new ArrayList<String>(Arrays.asList([string])) 
Collection.toArray(new String[0]);
list.subList(start,end)
Collection.sort()

Collection.synchronizedList
Collection.synchronizedSet
           synchronized

Comparable com可若波
Comparator com派瑞的
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
int read(byte[] byte)  实际的字节量 读到的字节

raf.length()

####IO
fileInputStream(path, append)
fileOutputStream(path, append)

ObjectInputStream  对象输入流 readObject()、 //向下造型 serialVersionUID
ObjectOutputStream 对象序列化 writeObject() //Serializable  忽略 transient

BufferedInputStream(fos); 块读写
BufferedOutputStream(fos); 缓冲 快速

//转换流
InputStreamReader(fis, "UTF-8")    int read(char[]) 字符流
OutputStreamWriter(fis, "UTF-8")  write(string)

BufferedReader()     缓冲字符流    readLine
BufferedWriter()     缓冲字符流


printWrite(path, "UTF-8") println
```java
public PrintWriter(String fileName) throws FileNotFoundException {
    this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))),
    false);
}
```

### reflect 类对象
newInstance 实例化 9out

method.invoke(o, null);

类名.class
Class.forName(string)


###lambdael


## 
thread runnable 
Thread.currentThread
thread.join()
thread.sleep(1000)
thread.interrupt(); 中断阻塞状态
synchronized
synchromized(同一个 同步监视器对象){
    需要同步运行的代码片段
}
静态方法 同步监视器为类对象

### threadpool
ExecutorService threadPool = Executors.newFixedThreadPool(2);
threadPool.execute(Runnable);
threadPool.shutdown();
threadPool.shutdownNow();

###

###date


###socket