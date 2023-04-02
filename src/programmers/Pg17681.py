# 비밀지도

def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        bin_1 = bin(arr1[i])[2:]
        bin_2 = bin(arr2[i])[2:]
        while len(bin_1) < n:
            bin_1 = '0' + bin_1
        while len(bin_2) < n:
            bin_2 = '0' + bin_2

        tmp = ''
        for j in range(len(bin_1)):
            if bin_1[j] == '0' and bin_2[j] == '0':
                tmp+=' '
            else:
                tmp+='#'
        answer.append(tmp)
    return answer