import java.awt.*;

/**
	Esta classe representa a bola usada no jogo. A classe princial do jogo (Pong)
	instancia um objeto deste tipo quando a execução é iniciada.
*/

public class Ball {
  private double cx;
  private double cy;
  private double width;
  private double height;
  private double centerHeight;
  private double centerWidth;
  private Color color;
  private double speed;
  private double directionX;
  private double directionY;

  /**
    Construtor da classe Ball. Observe que quem invoca o construtor desta classe define a velocidade da bola 
    (em pixels por millisegundo), mas não define a direção deste movimento. A direção do movimento é determinada 
    aleatóriamente pelo construtor.

    @param cx coordenada x da posição inicial da bola (centro do retangulo que a representa).
    @param cy coordenada y da posição inicial da bola (centro do retangulo que a representa).
    @param width largura do retangulo que representa a bola.
    @param height altura do retangulo que representa a bola.
    @param color cor da bola.
    @param speed velocidade da bola (em pixels por millisegundo).
  */

  public Ball(
    double cx,
    double cy,
    double width,
    double height,
    Color color,
    double speed
  ) {
    this.cx = cx;
    this.cy = cy;
    this.width = width;
    this.height = height;
    this.centerHeight = height / 2;
    this.centerWidth = width / 2;
    this.color = color;
    this.speed = speed;
    this.directionX = speed;
    this.directionY = speed;
  }

  /**
		Método chamado sempre que a bola precisa ser (re)desenhada.
		Detalhe: o y começa a ser contado de cima para baixo
		O meio da arena é 400 e 300
		a bola encosta na borda inferior direita quando está na posição 770 e 570
	*/

  public void draw() {
    GameLib.setColor(color);
    GameLib.fillRect(cx, cy, width, height);
  }

  /**
		Método chamado quando o estado (posição) da bola precisa ser atualizado.
		
		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

  public void update(long delta) {
    cx += this.directionX * delta;
    cy += this.directionY * delta;
  }

  /**
		Método chamado quando detecta-se uma colisão da bola com um jogador.
	
		@param playerId uma string cujo conteúdo identifica um dos jogadores.
	*/

  public void onPlayerCollision(String playerId) {
    this.directionX = playerId.equals("Player 1") ? Math.abs(this.speed) : - Math.abs(this.speed);
  }

  /**
		Método chamado quando detecta-se uma colisão da bola com uma parede.
		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra. |
	*/

  public void onWallCollision(String wallId) {
    if (wallId.equals("Top")) this.directionY = Math.abs(this.speed);

    if (wallId.equals("Bottom")) this.directionY = - Math.abs(this.speed);

    if (wallId.equals("Left")) this.directionX = Math.abs(this.speed);

    if (wallId.equals("Right")) this.directionX = - Math.abs(this.speed);
  }

  private boolean ballHitsTop(Wall wall) {
    double wallBottom = wall.getCy() + (wall.getHeight() / 2);
    double ballTop = this.cy - this.centerHeight;

    return ballTop <= wallBottom;
  }

  private boolean ballHitsBottom(Wall wall) {
    double wallTop = wall.getCy() - (wall.getHeight() / 2);
    double ballBottom = this.cy + this.centerHeight;

    return ballBottom >= wallTop;
  }

  private boolean ballHitsLeft(Wall wall) {
    double wallRight = wall.getCx() + (wall.getWidth() / 2);
    double ballLeft = this.cx - this.centerWidth;

    return ballLeft <= wallRight;
  }

  private boolean ballHitsRight(Wall wall) {
    double wallLeft = wall.getCx() - (wall.getWidth() / 2);
    double ballRight = this.cx + this.centerWidth;

    return ballRight >= wallLeft;
  }

  /**
		Método que verifica se houve colisão da bola com uma parede.
		@param wall referência para uma instância de Wall contra a qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/

  public boolean checkCollision(Wall wall) {
    String wallId = wall.getId();

    if (wallId.equals("Top")) return ballHitsTop(wall);

    if (wallId.equals("Bottom")) return ballHitsBottom(wall);

    if (wallId.equals("Left")) return ballHitsLeft(wall);

    if (wallId.equals("Right")) return ballHitsRight(wall);

    return false;
  }

  /**
		Método que verifica se houve colisão da bola com um jogador.
		@param player referência para uma instância de Player contra o qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/

  public boolean checkCollision(Player player) {
    double ballTop    = this.cy - this.centerHeight;
    double ballBottom = this.cy + this.centerHeight;
    double ballLeft   = this.cx - this.centerWidth;
    double ballRight  = this.cx + this.centerWidth;

    double playerTop    = player.getCy() - (player.getHeight() / 2);
    double playerBottom = player.getCy() + (player.getHeight() / 2);
    double playerLeft   = player.getCx() - (player.getWidth() / 2);
    double playerRight  = player.getCx() + (player.getWidth() / 2);

    boolean colisionRight  = ballLeft <= playerRight;
    boolean colisionLeft   = ballRight >= playerLeft;
    boolean colisionTop    = ballBottom >= playerTop;
    boolean colisionBottom = ballTop <= playerBottom;

    boolean ballBetweenPlayerTopAndBottom = colisionTop && colisionBottom;

    return colisionRight && colisionLeft && ballBetweenPlayerTopAndBottom;
  }

  /**
		Método que devolve a coordenada x do centro do retângulo que representa a bola.
		@return o valor double da coordenada x.
	*/

  public double getCx() {
    return this.cx;
  }

  /**
		Método que devolve a coordenada y do centro do retângulo que representa a bola.
		@return o valor double da coordenada y.
	*/

  public double getCy() {
    return this.cy;
  }

  /**
		Método que devolve a velocidade da bola.
		@return o valor double da velocidade.
	*/

  public double getSpeed() {
    return this.speed;
  }
}
