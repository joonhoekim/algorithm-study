def is_balanced(s):
    stack = []
    brackets = {'(': ')', '[': ']'}
    
    for char in s:
        if char in '([':  # Opening brackets
            stack.append(char)
        elif char in ')]':  # Closing brackets
            if not stack:  # Empty stack
                return False
            if char != brackets[stack.pop()]:  # Mismatch
                return False
    
    return len(stack) == 0  # Check if all brackets closed

while True:
    s = input()
    if s == '.':
        break
    
    # Remove last '.' and check balance
    print('yes' if is_balanced(s[:-1]) else 'no')