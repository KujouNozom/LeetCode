class Solution:
    def countPrimes(self, n: int) -> int:
        current_primes = []
        primes_flag = [True] * n

        for index in range(2, n):
            if primes_flag[index]:
                current_primes.append(index)
            for index_primes in range(len(current_primes)):
                value = index * current_primes[index_primes]
                if value >= n:
                    break
                primes_flag[value] = False
                if not index % current_primes[index_primes]:
                    break

        return len(current_primes)
