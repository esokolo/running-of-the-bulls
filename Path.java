package com.Lab;

public class Path
{
    private int[] currentLocation;
    private int[] upperLocation;
    private int[] lowerLocation;
    private int[] lefterLocation;
    private int[] righterLocation;
    private int[] objective;
    boolean left, right, up, down;
    private Coordinate[][] coordinates;

    public Path(Coordinate[][] coordinates)
    {
        this.coordinates = coordinates;
        this.objective = new int[]{
                coordinates[0].length - 1,
                coordinates[1].length - 2};
        currentLocation = new int[] {1, 1};
        upperLocation = new int[] {0, 1};
        lowerLocation = new int[] {2, 1};
        lefterLocation = new int[] {1, 0};
        righterLocation = new int[] {1, 2};
        left = false; right = false;
        up = false; down = false;
        getPossibleEvents();
        move();
        //move();
    }

    private void goRight()
    {
        if (currentLocation[1] < objective[1])
        {
            currentLocation[1] += 1;
            upperLocation[1] += 1;
            lowerLocation[1] += 1;
            lefterLocation[1] += 1;
            righterLocation[1] += 1;
        }
    }

    private void goLeft()
    {
        if (currentLocation[1] > 1)
        {
            currentLocation[1] -= 1;
            upperLocation[1] -= 1;
            lowerLocation[1] -= 1;
            lefterLocation[1] -= 1;
            righterLocation[1] -= 1;
        }
    }

    private void goUp()
    {
        if (currentLocation[0] > 1)
        {
            currentLocation[0] -= 1;
            upperLocation[0] -= 1;
            lowerLocation[0] -= 1;
            lefterLocation[0] -= 1;
            righterLocation[0] -= 1;
        }
    }

    private void goDown()
    {
        if (currentLocation[0] < objective[0] - 2)
        {
            currentLocation[0] += 1;
            upperLocation[0] += 1;
            lowerLocation[0] += 1;
            lefterLocation[0] += 1;
            righterLocation[0] += 1;
        }
    }

    private void getPossibleEvents()
    {
        right = false; left = false;
        up = false; down = false;

        if (currentLocation[0] > 1)
        {
            goUp();
            if (coordinates[currentLocation[0]]
                    [currentLocation[1]].
                    getValue() == ' ')
                this.up = true;
            goDown();
        }

        if (currentLocation[0] < objective[0] - 2)
        {
            goDown();
            if (coordinates[currentLocation[0]]
                    [currentLocation[1]].
                    getValue() == ' ')
                this.down = true;
            goUp();
        }

        if (currentLocation[1] < objective[1])
        {
            goRight();
            if (coordinates[currentLocation[0]]
                    [currentLocation[1]].
                    getValue() == ' ')
                this.right = true;
            goLeft();
        }

        if (currentLocation[1] > 1)
        {
            goLeft();
            if (coordinates[currentLocation[0]]
                    [currentLocation[1]].
                    getValue() == ' ')
                this.left = true;
            goRight();
        }
    }

    private void move()
    {
        if (right)
        {
            goRight();
            getPossibleEvents();
            move();
        }

        if (down)
        {
            goDown();
            getPossibleEvents();
            move();
        }

        if (!(right || down) && currentLocation[1] < objective[1])
        {
            if (currentLocation[0] % 2 == 0)
            {
                right = true;
                coordinates[currentLocation[0]]
                        [currentLocation[1] + 1].setValue(' ');
                getPossibleEvents();
                move();
            }
            else if (currentLocation[0] < objective[0] - 2)
            {
                down = true;
                coordinates[currentLocation[0] + 1]
                        [currentLocation[1]].setValue(' ');
                getPossibleEvents();
                move();
            }
        }

        if (23 == currentLocation[1] && currentLocation[0] < objective[0] - 2)
        {
            down = true;
            coordinates[currentLocation[0] + 1]
                    [currentLocation[1]].setValue(' ');
            getPossibleEvents();
            move();
        }
    }

}
