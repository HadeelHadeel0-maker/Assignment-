/**
 * أمثلة متقدمة للهياكل البيانات
 * إعداد: جهاد المنبهي
 * المجموعة الأولى - ذكاء أعمال
 */

import java.util.*;

public class AdvancedDataStructures {
    
    public static void main(String[] args) {
        System.out.println("=== أمثلة متقدمة للهياكل البيانات ===");
        System.out.println("إعداد: جهاد المنبهي - المجموعة الأولى");
        System.out.println();
        
        // 1. نظام إدارة المكتبة
        demonstrateLibrarySystem();
        
        // 2. نظام الملفات الهرمي
        demonstrateFileSystem();
        
        // 3. نظام إدارة المهام
        demonstrateTaskManager();
        
        // 4. نظام التخزين المؤقت
        demonstrateCacheSystem();
        
        // 5. نظام الرسائل
        demonstrateMessageSystem();
    }
    
    /**
     * نظام إدارة المكتبة
     */
    public static void demonstrateLibrarySystem() {
        System.out.println("--- 1. نظام إدارة المكتبة ---");
        
        LibrarySystem library = new LibrarySystem();
        
        // إضافة كتب للمكتبة
        library.addBook(new Book("1001", "البرمجة بلغة Java", "أحمد محمد", 2020));
        library.addBook(new Book("1002", "الخوارزميات وهياكل البيانات", "فهد سعود", 2019));
        library.addBook(new Book("1003", "الذكاء الاصطناعي", "سعد خالد", 2021));
        
        // البحث عن كتاب
        Book book = library.findBook("1002");
        System.out.println("الكتاب الموجود: " + book);
        
        // استعارة كتاب
        library.borrowBook("1001", "طالب1");
        library.borrowBook("1003", "طالب2");
        
        // عرض الكتب المستعارة
        System.out.println("الكتب المستعارة:");
        library.displayBorrowedBooks();
        
        System.out.println();
    }
    
    /**
     * نظام الملفات الهرمي
     */
    public static void demonstrateFileSystem() {
        System.out.println("--- 2. نظام الملفات الهرمي ---");
        
        FileSystem fs = new FileSystem();
        fs.createSampleFileSystem();
        
        // عرض هيكل الملفات
        System.out.println("هيكل الملفات:");
        fs.displayFileSystem();
        
        // البحث عن ملف
        FileNode file = fs.findFile("report.pdf");
        System.out.println("الملف الموجود: " + (file != null ? file.name : "غير موجود"));
        
        System.out.println();
    }
    
    /**
     * نظام إدارة المهام
     */
    public static void demonstrateTaskManager() {
        System.out.println("--- 3. نظام إدارة المهام ---");
        
        TaskManager taskManager = new TaskManager();
        
        // إضافة مهام بأولويات مختلفة
        taskManager.addTask(new Task("إعداد التقرير", "عالٍ", 3));
        taskManager.addTask(new Task("الرد على الإيميلات", "متوسط", 2));
        taskManager.addTask(new Task("اجتماع الفريق", "عالٍ", 1));
        taskManager.addTask(new Task("مراجعة الكود", "منخفض", 4));
        
        // تنفيذ المهام حسب الأولوية
        System.out.println("تنفيذ المهام حسب الأولوية:");
        while (taskManager.hasTasks()) {
            Task task = taskManager.executeNextTask();
            System.out.println("تم تنفيذ: " + task.description + " (الأولوية: " + task.priority + ")");
        }
        
        System.out.println();
    }
    
    /**
     * نظام التخزين المؤقت
     */
    public static void demonstrateCacheSystem() {
        System.out.println("--- 4. نظام التخزين المؤقت (LRU Cache) ---");
        
        LRUCache cache = new LRUCache(3);
        
        // إضافة عناصر للكاش
        cache.put("user1", "بيانات المستخدم 1");
        cache.put("user2", "بيانات المستخدم 2");
        cache.put("user3", "بيانات المستخدم 3");
        
        System.out.println("الكاش بعد إضافة 3 عناصر:");
        cache.display();
        
        // الوصول لعنصر
        String data = cache.get("user1");
        System.out.println("البيانات المسترجعة: " + data);
        
        // إضافة عنصر جديد (سيتم حذف الأقل استخدام)
        cache.put("user4", "بيانات المستخدم 4");
        
        System.out.println("الكاش بعد إضافة عنصر جديد:");
        cache.display();
        
        System.out.println();
    }
    
    /**
     * نظام الرسائل
     */
    public static void demonstrateMessageSystem() {
        System.out.println("--- 5. نظام الرسائل ---");
        
        MessageSystem messageSystem = new MessageSystem();
        
        // إضافة رسائل
        messageSystem.addMessage(new Message("أحمد", "مرحباً، كيف حالك؟", "2024-01-15 10:00"));
        messageSystem.addMessage(new Message("فهد", "المشروع جاهز للمراجعة", "2024-01-15 11:30"));
        messageSystem.addMessage(new Message("سعد", "موعد الاجتماع غداً الساعة 9", "2024-01-15 14:20"));
        
        // عرض الرسائل
        System.out.println("جميع الرسائل:");
        messageSystem.displayAllMessages();
        
        // البحث عن رسائل من شخص معين
        System.out.println("\nالرسائل من أحمد:");
        List<Message> ahmedMessages = messageSystem.findMessagesBySender("أحمد");
        for (Message msg : ahmedMessages) {
            System.out.println(msg);
        }
        
        System.out.println();
    }
}

/**
 * فئة الكتاب
 */
class Book {
    String isbn;
    String title;
    String author;
    int year;
    boolean isBorrowed;
    String borrowedBy;
    
    Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isBorrowed = false;
        this.borrowedBy = "";
    }
    
    @Override
    public String toString() {
        return title + " - " + author + " (" + year + ")";
    }
}

/**
 * نظام إدارة المكتبة
 */
class LibrarySystem {
    private HashMap<String, Book> booksByISBN;
    private HashMap<String, List<Book>> booksByAuthor;
    private Queue<Book> borrowedBooks;
    
    public LibrarySystem() {
        booksByISBN = new HashMap<>();
        booksByAuthor = new HashMap<>();
        borrowedBooks = new LinkedList<>();
    }
    
    public void addBook(Book book) {
        booksByISBN.put(book.isbn, book);
        
        booksByAuthor.computeIfAbsent(book.author, k -> new ArrayList<>()).add(book);
    }
    
    public Book findBook(String isbn) {
        return booksByISBN.get(isbn);
    }
    
    public List<Book> findBooksByAuthor(String author) {
        return booksByAuthor.getOrDefault(author, new ArrayList<>());
    }
    
    public boolean borrowBook(String isbn, String borrower) {
        Book book = booksByISBN.get(isbn);
        if (book != null && !book.isBorrowed) {
            book.isBorrowed = true;
            book.borrowedBy = borrower;
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }
    
    public void displayBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.title + " (مستعارة بواسطة: " + book.borrowedBy + ")");
        }
    }
}

/**
 * عقدة الملف في نظام الملفات
 */
class FileNode {
    String name;
    boolean isDirectory;
    List<FileNode> children;
    
    FileNode(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.children = new ArrayList<>();
    }
    
    void addChild(FileNode child) {
        children.add(child);
    }
}

/**
 * نظام الملفات الهرمي
 */
class FileSystem {
    private FileNode root;
    
    public void createSampleFileSystem() {
        root = new FileNode("root", true);
        
        FileNode documents = new FileNode("Documents", true);
        FileNode pictures = new FileNode("Pictures", true);
        FileNode programs = new FileNode("Programs", true);
        
        // إضافة ملفات للمستندات
        documents.addChild(new FileNode("report.pdf", false));
        documents.addChild(new FileNode("presentation.pptx", false));
        documents.addChild(new FileNode("notes.txt", false));
        
        // إضافة ملفات للصور
        pictures.addChild(new FileNode("vacation.jpg", false));
        pictures.addChild(new FileNode("family.png", false));
        
        // إضافة ملفات للبرامج
        programs.addChild(new FileNode("DataStructures.java", false));
        programs.addChild(new FileNode("Algorithms.py", false));
        
        root.addChild(documents);
        root.addChild(pictures);
        root.addChild(programs);
    }
    
    public FileNode findFile(String fileName) {
        return findFileRecursive(root, fileName);
    }
    
    private FileNode findFileRecursive(FileNode node, String fileName) {
        if (node.name.equals(fileName) && !node.isDirectory) {
            return node;
        }
        
        for (FileNode child : node.children) {
            FileNode found = findFileRecursive(child, fileName);
            if (found != null) {
                return found;
            }
        }
        
        return null;
    }
    
    public void displayFileSystem() {
        displayFileSystemRecursive(root, 0);
    }
    
    private void displayFileSystemRecursive(FileNode node, int level) {
        String indent = "  ".repeat(level);
        String prefix = node.isDirectory ? "[دليل] " : "[ملف] ";
        System.out.println(indent + prefix + node.name);
        
        for (FileNode child : node.children) {
            displayFileSystemRecursive(child, level + 1);
        }
    }
}

/**
 * فئة المهمة
 */
class Task {
    String description;
    String priority;
    int order;
    
    Task(String description, String priority, int order) {
        this.description = description;
        this.priority = priority;
        this.order = order;
    }
    
    @Override
    public String toString() {
        return description + " (الأولوية: " + priority + ")";
    }
}

/**
 * نظام إدارة المهام
 */
class TaskManager {
    private PriorityQueue<Task> tasks;
    private int taskCounter;
    
    public TaskManager() {
        tasks = new PriorityQueue<>((t1, t2) -> {
            // ترتيب حسب الأولوية: عالٍ > متوسط > منخفض
            int priority1 = getPriorityValue(t1.priority);
            int priority2 = getPriorityValue(t2.priority);
            
            if (priority1 != priority2) {
                return Integer.compare(priority2, priority1); // عكسي للأولوية الأعلى أولاً
            }
            return Integer.compare(t1.order, t2.order); // نفس الأولوية، حسب الترتيب
        });
        taskCounter = 0;
    }
    
    private int getPriorityValue(String priority) {
        switch (priority) {
            case "عالٍ": return 3;
            case "متوسط": return 2;
            case "منخفض": return 1;
            default: return 0;
        }
    }
    
    public void addTask(Task task) {
        task.order = taskCounter++;
        tasks.add(task);
    }
    
    public Task executeNextTask() {
        return tasks.poll();
    }
    
    public boolean hasTasks() {
        return !tasks.isEmpty();
    }
}

/**
 * نظام التخزين المؤقت LRU
 */
class LRUCache {
    private int capacity;
    private LinkedHashMap<String, String> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<String, String>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public void put(String key, String value) {
        cache.put(key, value);
    }
    
    public String get(String key) {
        return cache.get(key);
    }
    
    public void display() {
        System.out.println("محتويات الكاش (من الأحدث للأقدم):");
        for (Map.Entry<String, String> entry : cache.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

/**
 * فئة الرسالة
 */
class Message {
    String sender;
    String content;
    String timestamp;
    
    Message(String sender, String content, String timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + ": " + content;
    }
}

/**
 * نظام الرسائل
 */
class MessageSystem {
    private List<Message> messages;
    private HashMap<String, List<Message>> messagesBySender;
    
    public MessageSystem() {
        messages = new ArrayList<>();
        messagesBySender = new HashMap<>();
    }
    
    public void addMessage(Message message) {
        messages.add(message);
        messagesBySender.computeIfAbsent(message.sender, k -> new ArrayList<>()).add(message);
    }
    
    public List<Message> findMessagesBySender(String sender) {
        return messagesBySender.getOrDefault(sender, new ArrayList<>());
    }
    
    public void displayAllMessages() {
        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
