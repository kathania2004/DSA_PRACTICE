class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Opening bracket: push it
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // Closing bracket: stack must not be empty
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check that the top matches this closing bracket
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Valid only if nothing is left unmatched
        return stack.isEmpty();
    }
}