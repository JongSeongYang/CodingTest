# 위장

def solution(clothes):
    hash = {}
    for cloth, type in clothes:
        hash[type] = hash.get(type, 0) + 1

    # 입지 않는 경우를 추가하여 모든 조합 계산하기
    answer = 1
    for type in hash_map:
        answer *= (hash[type] + 1)

    # 아무종류의 옷도 입지 않는 경우 제외하기
    return answer - 1