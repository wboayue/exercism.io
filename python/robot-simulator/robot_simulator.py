from enum import Enum

class Bearing(Enum):
    NORTH = ('WEST', 'EAST', (0, 1))
    SOUTH = ('EAST', 'WEST', (0, -1))
    EAST = ('NORTH', 'SOUTH', (1, 0))
    WEST = ('SOUTH', 'NORTH', (-1, 0))

    def __init__(self, left, right, delta):
        self.left = left
        self.right = right
        self.delta = delta

for bearing in Bearing:
    bearing.left = Bearing[bearing.left]
    bearing.right = Bearing[bearing.right]
    vars()[bearing.name] = bearing

class Robot(object):
    def __init__(self, bearing=Bearing.NORTH, x=0, y=0):
        self.bearing = bearing
        self.coordinates = (x, y)

    def advance(self):
        self.coordinates = (
            self.coordinates[0] + self.bearing.delta[0],
            self.coordinates[1] + self.bearing.delta[1])

    def turn_right(self):
        self.bearing = self.bearing.right

    def turn_left(self):
        self.bearing = self.bearing.left

    def simulate(self, actions):
        for action in actions:
            self.perform(action)

    def perform(self, action):
        {
            'A': self.advance,
            'L': self.turn_left,
            'R': self.turn_right,
        }[action]()
