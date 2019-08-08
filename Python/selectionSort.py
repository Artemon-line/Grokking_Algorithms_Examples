from assets.helper import print_stat


def findSmallest(list):
    smallest = list[0]
    smallest_index = 0
    for i in range(1, len(list)):
        if (list[i]) < smallest:
            smallest = list[i]
            smallest_index = i
    return smallest_index


def selectionSort(list):
    steps = 0
    newArr = []
    for item in range(len(list)):
        small = findSmallest(list)
        newArr.append(list.pop(small))
        steps += 1
    print_stat(len(newArr), steps)
    return newArr


res = selectionSort([5, 3, 6, 2, 10, 4, 8, 9, 22, 19])
print(res)
