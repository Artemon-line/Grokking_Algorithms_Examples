import helper


def binary_search(list, item):
    low = 0
    high = len(list) - 1
    steps = 0

    while low <= high:
        mid = (low + high) / 2
        guess = list[mid]
        steps += 1
        if guess == item:
            helper.print_stat(len(list), steps)
            return guess
        if guess > item:
            high = mid - 1
        else:
            low = mid + 1
    helper.print_stat(len(list), steps)
    return None


if __name__ == "__main__":
    my_list = [1, 3, 5, 7, 9, 11, 16, 17, 19, 22, 25, 27, 29, 33]
    res1 = binary_search(my_list, 7)
    print(res1)  # => 1
    res2 = binary_search(my_list, -1)
    print(res2)  # => None
