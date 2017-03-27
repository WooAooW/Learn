#encoding=utf-8

class Screen(object):

    @property
    def width(self):
        return self._width

    @width.setter
    def width(self, value):
        if(value <= 0):
            raise ValueError("宽度必须为正数")
        self._width = value

    @property
    def height(self):
        return self._height

    @height.setter
    def height(self, value):
        if(value <= 0):
            raise ValueError("高度必须为正数")
        self._height = value

    @property
    def resolution(self):
        return self._width * self._height

s = Screen()
s.width = 1024
s.height = 768
print(s.resolution)
assert s.resolution == 786432, '1024 * 768 = %d ?' % s.resolution