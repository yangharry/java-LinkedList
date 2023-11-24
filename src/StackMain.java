public class StackMain {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("yang");
        stack.push("hee");
        stack.push("il");
        stack.push("yang");
        stack.push("hee");
        stack.push("il");

        System.out.println("Size of stack: " + stack.size());
        System.out.println("delete element: " + stack.pop());
        System.out.println("Size of stack: " + stack.size());
        stack.pop();
        System.out.println("Size of stack: " + stack.size());
        System.out.println("Peek of stack: " + stack.peek());
        System.out.println("Size of stack: " + stack.isEmpty());

        for (String i : stack) {
            System.out.println(i);
        }
    }
}
