# 문자열 나누기

def solution(s):
    answer = 0
    diff = 0
    same = 0
    x = s[0]
    for i in range(len(s)):
        if x==s[i]:
            same+=1
        else:
            diff+=1
        if i+1 < len(s):
            if same == diff:
                answer+=1
                x = s[i+1]
    answer+=1
    return answer