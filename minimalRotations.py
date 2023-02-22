s = input()
s *= 2
n = len(s)
i = 0
ans = 0

while i < n//2:
    ans = i
    k, j = i, i + 1

    while j < n and s[j] >= s[k]:
        if s[j] == s[k]:
            k += 1
        elif s[j] > s[k]:
            k = i
        j += 1

    i += max(1, j - k)

print(s[ans:ans+n//2])
