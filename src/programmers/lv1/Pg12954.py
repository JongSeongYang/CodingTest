# x만큼 간격이 있는 n개의 숫자

def solution(x, n):
    answer = []
    if x >0:
        for i in range(x,x*n+1,x):
            answer.append(i)
    elif x ==0:
        for i in range(n):
            answer.append(0)
    else:
        for i in range(x,x*n-1,x):
            answer.append(i)
    return answer