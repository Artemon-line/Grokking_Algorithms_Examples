import random
from assets.helper import print_stat

steps = 0


def quicksort(arr):
    if len(arr) < 2:
        return arr
    else:
        pivot = arr[0]
        less = [i for i in arr[1:] if i <= pivot]
        more = [i for i in arr[1:] if i > pivot]
        return quicksort(less) + [pivot] + quicksort(more)


if __name__ == "__main__":
    unsorted = [10, 5, 2, 3, 11, 1, 33, 543, 44, 59, 2393, 75]
    print(unsorted)
    sorted = quicksort(unsorted)
    print(sorted)
    print_stat(len(unsorted), steps)