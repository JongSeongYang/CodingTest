# 올바른 괄호

def solution(s):
    if s.startswith(")") or s.endswith("("):
        return False
    stack = []
    for i in range(len(s)):
        if(s[i]=="("):
            stack.append("(")
        elif len(stack) !=0 and s[i]==")":
            stack.pop()
    if(len(stack)==0):
        return True;
    return False;