object Main{

	def main(args: Array[String]){
		game()
	}

	def game(){
		var playerOneInput : Int = 0
		var playerTwoInput : Int = 0
		var gameBoard = Array(" ", " ", " ", " ", " ", " ", " ", " ", " ")
		var didWin : Boolean = false
		var playerTurn: Boolean = true
		var restart: String = "n"



		while(!didWin){

			if(playerTurn){

				initialGrid(gameBoard)

				print("Player one [X], please choose a cell (1-9): ")

				playerOneInput = scala.io.StdIn.readInt()

				while((playerOneInput > 9) || (playerOneInput < 1) || (gameBoard(playerOneInput-1) != " ")){
					print("Please try again: ")
					playerOneInput = scala.io.StdIn.readInt()
				} 

				gameBoard(playerOneInput-1) = "X"

				didWin = winCondition(gameBoard)

				playerTurn = !playerTurn
			} else {

				initialGrid(gameBoard)

				print("Player two [O], please choose a cell (1-9): ")

				playerTwoInput = scala.io.StdIn.readInt()

				while((playerTwoInput > 9) || (playerTwoInput < 1) || (gameBoard(playerTwoInput-1) != " ")){
					print("Please try again: ")
					playerTwoInput = scala.io.StdIn.readInt()
				} 

				gameBoard(playerTwoInput-1) = "O"

				didWin = winCondition(gameBoard)

				playerTurn = !playerTurn
			}
		}

		initialGrid(gameBoard)

		if(playerTurn){
			print("Congratulations Player Two!!! ")
		} else {
			print("Congratulations Player One!!! ")
		}

		print("Play again? (y/n): ")
		restart = scala.io.StdIn.readLine()

		if(restart == "y"){
			game()
		} 

	}

	def initialGrid(boardArray: Array[String]){
		print(" " + boardArray(0) + " | " + boardArray(1) + " | " + boardArray(2) + '\n')
		print(" " + boardArray(3) + " | " + boardArray(4) + " | " + boardArray(5) + '\n')
		print(" " + boardArray(6) + " | " + boardArray(7) + " | " + boardArray(8) + '\n')
	}

	def winCondition(boardArray: Array[String]): Boolean = {
		if((boardArray(0) == boardArray(1) && boardArray(1) == boardArray(2)) && (boardArray(0) != " ")){
			return true
		} else if((boardArray(3) == boardArray(4) && boardArray(4) == boardArray(5)) && (boardArray(3) != " ")){
			return true
		} else if((boardArray(6) == boardArray(7) && boardArray(7) == boardArray(8)) && (boardArray(6) != " ")){
			return true
		} else if((boardArray(0) == boardArray(3) && boardArray(3) == boardArray(6)) && (boardArray(0) != " ")){
			return true
		} else if((boardArray(1) == boardArray(4) && boardArray(4) == boardArray(7)) && (boardArray(1) != " ")){
			return true
		} else if((boardArray(2) == boardArray(5) && boardArray(5) == boardArray(8)) && (boardArray(2) != " ")){
			return true
		} else if((boardArray(0) == boardArray(4) && boardArray(4) == boardArray(8)) && (boardArray(0) != " ")){
			return true
		} else if((boardArray(2) == boardArray(4) && boardArray(4) == boardArray(6)) && (boardArray(2) != " ")){
			return true
		} 

		return false
	}


}