# 짝지어 제거하기

def solution(s):
    answer = 0
    stack = []
    for i in range(len(s)):
        if len(stack) == 0:
            stack.append(s[i])
        else:
            last = stack.pop()
            if last != s[i]:
                stack.append(last)
                stack.append(s[i])
    if len(stack) == 0:
        answer = 1
    return answer