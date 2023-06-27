# 약수의 개수와 덧셈

def solution(left, right):
    answer = 0
    for i in range(left,right+1):
        if getLenDivisor(i)%2==0:
            answer+=i
        else:
            answer-=i
    return answer


def getLenDivisor(n):
    divisorsList = []
    for i in range(1, int(n**(1/2)) + 1):
        if (n % i == 0):
            divisorsList.append(i)
            if ( (i**2) != n) :
                divisorsList.append(n // i)
    divisorsList.sort()
    return len(divisorsList)