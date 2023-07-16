// в теории случай казалось бы элементарный квадрат частный случай прямоугольника.
//Но  на деле и при реализации  мы сталкиваемся с проблеммой, что если 
//унаследовать квадрат у прямоугольника  принцип LSP не соблюдается функционал не расширяется а переписывается 
// так что в голову пришла только такая идея
public class LSP {
    public interface iWidth {
        void setWidth(int width);
    }

    public interface iHeight {
        void setHeight(int height);
    }

    public interface iSide {
        void setSide(int height);
    }

    public class Quadrangle {

        private int width;
        private int height;

        public Quadrangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int area() {
            return this.width * this.height;
        }
    }

    public class Rectangle extends Quadrangle implements iWidth, iHeight {

        public Rectangle(int width, int height) {
            super(width, height);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void setWidth(int width) {
            super.width = width;
        }

        @Override
        public void setHeight(int height) {
            super.height = height;
        }

    }

    public class Square extends Quadrangle implements iSide {
        public Square(int width, int height) {
            super(width, height);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void setSide(int side) {
            super.width = side;
            super.height = side;
        }

    }

}
