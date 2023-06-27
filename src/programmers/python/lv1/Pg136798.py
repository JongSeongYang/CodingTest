# 기사단원의 무기

def solution(number, limit, power):
    answer = 0
    for i in range(1, number+1):
        n = getDivisor(i)
        if n > limit:
            n = power
        answer+=n
    return answer



def getDivisor(n):
    divisors = []
    for i in range(1, int(n**(1/2)) + 1):
        if (n % i == 0):
            divisors.append(i)
            if ( (i**2) != n) :
                divisors.append(n // i)
    return len(divisors)