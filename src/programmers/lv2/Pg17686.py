# [3차] 파일명 정렬

def solution(files):
    dic = []
    head, num, tail = '', '', ''
    for file in files:
        for j in range(len(file)):
            if file[j].isdigit():
                head = file[:j]
                num = file[j:]
                for k in range(len(num)):
                    if not num[k].isdigit():
                        tail = num[k:]
                        num = num[:k]
                        break
                dic.append([head,num,tail])
                head, num, tail = '', '', ''
                break
    dic = sorted(dic, key=lambda x:(x[0].lower(),int(x[1])))
    return [''.join(i) for i in dic]