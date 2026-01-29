/**
 * ملف أمثلة الهياكل البيانات بلغة Java
 * إعداد: جهاد المنبهي
 * المجموعة الأولى - ذكاء أعمال
 */

import java.util.*;

public class DataStructuresExamples {
    
    public static void main(String[] args) {
        System.out.println("=== أمثلة الهياكل البيانات في Java ===");
        System.out.println("إعداد: جهاد المنبهي - المجموعة الأولى");
        System.out.println();
        
        // 1. أمثلة المصفوفات
        demonstrateArrays();
        
        // 2. أمثلة القوائم المرتبطة
        demonstrateLinkedLists();
        
        // 3. أمثلة المكدسات
        demonstrateStacks();
        
        // 4. أمثلة الطوابير
        demonstrateQueues();
        
        // 5. أمثلة جداول التجزئة
        demonstrateHashMaps();
        
        // 6. أمثلة الأشجار
        demonstrateTrees();
    }
    
    /**
     * عرض أمثلة المصفوفات
     */
    public static void demonstrateArrays() {
        System.out.println("--- 1. المصفوفات (Arrays) ---");
        
        // مصفوفة أعداد صحيحة
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("مصفوفة الأعداد: " + Arrays.toString(numbers));
        
        // الوصول للعناصر
        System.out.println("العنصر الأول: " + numbers[0]);
        System.out.println("العنصر الأخير: " + numbers[numbers.length - 1]);
        
        // البحث في المصفوفة
        int target = 30;
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                index = i;
                break;
            }
        }
        System.out.println("موقع الرقم " + target + ": " + index);
        
        // فرز المصفوفة
        int[] unsorted = {5, 2, 8, 1, 9};
        Arrays.sort(unsorted);
        System.out.println("مصفوفة بعد الفرز: " + Arrays.toString(unsorted));
        
        System.out.println();
    }
    
    /**
     * عرض أمثلة القوائم المرتبطة
     */
    public static void demonstrateLinkedLists() {
        System.out.println("--- 2. القوائم المرتبطة (Linked Lists) ---");
        
        LinkedList<String> names = new LinkedList<>();
        
        // إضافة عناصر
        names.add("أحمد");
        names.add("محمد");
        names.add("فهد");
        names.add("سعد");
        
        System.out.println("القائمة المرتبطة: " + names);
        
        // إضافة في البداية والنهاية
        names.addFirst("خالد");
        names.addLast("ياسر");
        
        System.out.println("بعد الإضافة في البداية والنهاية: " + names);
        
        // إزالة العناصر
        String removed = names.removeFirst();
        System.out.println("العنصر المحذوف من البداية: " + removed);
        System.out.println("القائمة بعد الحذف: " + names);
        
        // البحث عن عنصر
        boolean found = names.contains("فهد");
        System.out.println("هل 'فهد' موجود في القائمة؟ " + found);
        
        System.out.println();
    }
    
    /**
     * عرض أمثلة المكدسات
     */
    public static void demonstrateStacks() {
        System.out.println("--- 3. المكدسات (Stacks) - LIFO ---");
        
        Stack<String> books = new Stack<>();
        
        // إضافة كتب للمكدس
        books.push("كتاب الرياضيات");
        books.push("كتاب البرمجة");
        books.push("كتاب الذكاء الاصطناعي");
        books.push("كتاب الخوارزميات");
        
        System.out.println("المكدس: " + books);
        
        // النظر للعنصر العلوي
        String topBook = books.peek();
        System.out.println("الكتاب العلوي: " + topBook);
        
        // إزالة العنصر العلوي
        String removedBook = books.pop();
        System.out.println("الكتاب الذي تم إزالته: " + removedBook);
        System.out.println("المكدس بعد الإزالة: " + books);
        
        // تفريغ المكدس
        System.out.println("\nتفريغ المكدس:");
        while (!books.isEmpty()) {
            System.out.println("إزالة: " + books.pop());
        }
        
        System.out.println();
    }
    
    /**
     * عرض أمثلة الطوابير
     */
    public static void demonstrateQueues() {
        System.out.println("--- 4. الطوابير (Queues) - FIFO ---");
        
        Queue<String> customers = new LinkedList<>();
        
        // إضافة عملاء للطابور
        customers.add("العميل الأول");
        customers.add("العميل الثاني");
        customers.add("العميل الثالث");
        customers.add("العميل الرابع");
        
        System.out.println("الطابور: " + customers);
        
        // النظر للعميل الأول
        String firstCustomer = customers.peek();
        System.out.println("العميل الأول في الطابور: " + firstCustomer);
        
        // خدمة العملاء بالترتيب
        System.out.println("\nخدمة العملاء:");
        while (!customers.isEmpty()) {
            String served = customers.remove();
            System.out.println("تم خدمة: " + served);
        }
        
        System.out.println();
    }
    
    /**
     * عرض أمثلة جداول التجزئة
     */
    public static void demonstrateHashMaps() {
        System.out.println("--- 5. جداول التجزئة (HashMaps) ---");
        
        HashMap<String, Integer> studentGrades = new HashMap<>();
        
        // إضافة بيانات الطلاب
        studentGrades.put("أحمد محمد", 85);
        studentGrades.put("فهد سعود", 92);
        studentGrades.put("سعد خالد", 78);
        studentGrades.put("ياسر علي", 88);
        
        System.out.println("درجات الطلاب: " + studentGrades);
        
        // البحث عن درجة طالب
        String studentName = "فهد سعود";
        Integer grade = studentGrades.get(studentName);
        System.out.println("درجة طالب " + studentName + ": " + grade);
        
        // التحقق من وجود طالب
        boolean exists = studentGrades.containsKey("أحمد محمد");
        System.out.println("هل 'أحمد محمد' موجود؟ " + exists);
        
        // تعديل درجة طالب
        studentGrades.put("سعد خالد", 82);
        System.out.println("بعد تعديل درجة سعد: " + studentGrades);
        
        // عرض كل الطلاب ودرجاتهم
        System.out.println("\nجميع الطلاب ودرجاتهم:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println();
    }
    
    /**
     * عرض أمثلة الأشجار
     */
    public static void demonstrateTrees() {
        System.out.println("--- 6. الأشجار (Trees) ---");
        
        // إنشاء شجرة بحث ثنائية
        BST tree = new BST();
        
        // إادة قيم للشجرة
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            tree.insert(value);
        }
        
        System.out.println("شجرة البحث الثنائية تم إنشاؤها بالقيم: " + Arrays.toString(values));
        
        // البحث في الشجرة
        int searchValue = 40;
        boolean found = tree.search(searchValue);
        System.out.println("هل الرقم " + searchValue + " موجود في الشجرة؟ " + found);
        
        // العبور بالترتيب (In-order)
        System.out.print("العبور بالترتيب (In-order): ");
        tree.inOrderTraversal();
        System.out.println();
        
        // العبور بالطلب المسبق (Pre-order)
        System.out.print("العبور بالطلب المسبق (Pre-order): ");
        tree.preOrderTraversal();
        System.out.println();
        
        // العبور بالطلب اللاحق (Post-order)
        System.out.print("العبور بالطلب اللاحق (Post-order): ");
        tree.postOrderTraversal();
        System.out.println();
        
        System.out.println();
    }
}

/**
 * فئة شجرة البحث الثنائية
 */
class BST {
    private TreeNode root;
    
    /**
     * عقدة الشجرة
     */
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    /**
     * إضافة قيمة للشجرة
     */
    public void insert(int value) {
        root = insertRecursive(root, value);
    }
    
    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        
        return current;
    }
    
    /**
     * البحث عن قيمة في الشجرة
     */
    public boolean search(int value) {
        return searchRecursive(root, value);
    }
    
    private boolean searchRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        
        if (value == current.value) {
            return true;
        }
        
        return value < current.value 
            ? searchRecursive(current.left, value)
            : searchRecursive(current.right, value);
    }
    
    /**
     * العبور بالترتيب (In-order traversal)
     */
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }
    
    private void inOrderRecursive(TreeNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }
    
    /**
     * العبور بالطلب المسبق (Pre-order traversal)
     */
    public void preOrderTraversal() {
        preOrderRecursive(root);
    }
    
    private void preOrderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }
    
    /**
     * العبور بالطلب اللاحق (Post-order traversal)
     */
    public void postOrderTraversal() {
        postOrderRecursive(root);
    }
    
    private void postOrderRecursive(TreeNode node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.value + " ");
        }
    }
}
