from collections import deque, namedtuple

Bearing = namedtuple('Bearing', 'x y')

NORTH, SOUTH, EAST, WEST = Bearing(0, 1), Bearing(0, -1), Bearing(1, 0), Bearing(-1, 0)

def turn_towards(bearing):
    bearings = deque([NORTH, EAST, SOUTH, WEST])
    while bearings[0] != bearing:
        bearings.rotate(1)
    return bearings

class Robot(object):
    def __init__(self, bearing=NORTH, x=0, y=0):
        self.__bearings = turn_towards(bearing)
        self.coordinates = (x, y)

    @property
    def bearing(self):
        return self.__bearings[0]

    def advance(self):
        self.coordinates = (
            self.coordinates[0] + self.bearing.x,
            self.coordinates[1] + self.bearing.y)

    def turn_right(self):
        self.__bearings.rotate(-1)

    def turn_left(self):
        self.__bearings.rotate(1)

    def simulate(self, actions):
        for action in actions:
            if action == 'A':
                self.advance
            elif action == 'L':
                self.turn_left
            elif action == 'R':
                self.turn_right
            else: raise ValueError('Unknow action {}'.format(action))
