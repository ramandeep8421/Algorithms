class SummaryRanges:
    def __init__(self):
        self.values = set()

    def addValue(self, value):
        self.values.add(value)

    def getIntervals(self):
        if not self.values:
            return []

        intervals = []

        left, right = -1, -1

        for it in sorted(self.values):
            if left < 0:
                left = right = it
            elif it == right + 1:
                right = it
            else:
                intervals.append([left, right])
                left = right = it

        intervals.append([left, right])

        return intervals
