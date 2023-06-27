# 숫자 블록

def solution(begin, end):
    answer = []
    for i in range(begin, end + 1):
        if i == 1:
            answer.append(0)
        else:
            answer.append(getDivisor(i))

    return answer


def getDivisor(n):
    divisors = []
    for i in range(1, int(n ** (1 / 2)) + 1):
        if (n % i == 0):
            divisors.append(i)
            if ((i ** 2) != n):
                k = n // i
                if k <= 10000000:
                    divisors.append(k)
    divisors.sort()
    if divisors[-1] == n:
        divisors.pop()
    return divisors[-1]