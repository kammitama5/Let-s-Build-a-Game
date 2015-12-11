/**
 * 
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

/**
 * @author KMaughan
 *
 */
public class Menu extends MouseAdapter{
	
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud){
		this.game = game;
		this.hud = hud;
		this.handler = handler;
		
	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu){
			//play button
			if(mouseOver(mx, my, 210,  150,  200,  64)){
				game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
				
				AudioPlayer.getSound("menu_sound").play();
				
			}
			//help button 
			if(mouseOver(mx, my, 210,  250,  200,  64)){
				game.gameState = STATE.Help;
				
				AudioPlayer.getSound("menu_sound").play();
			}
			
			
			//quit button
			if(mouseOver(mx, my, 210,  350,  200,  64)){
				System.exit(1);
				
			}
		}
			
		
		
		
		
		
		//back button for help
		if(game.gameState == STATE.Help){
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				game.gameState = STATE.Menu;
				AudioPlayer.getSound("menu_sound").play();
				return;
			}
		}
		
		//back button for help
		if(game.gameState == STATE.Help){
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
				AudioPlayer.getSound("menu_sound").play();
			}
		}
		
}
		
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
		
	}
	
	public void tick(){
				
	}
	
	public void render(Graphics g){
		if(game.gameState == STATE.Menu){
			
		Font fnt = new Font("arial", 1, 20);
		Font fnt2 = new Font("arial", 1, 30);
		Font fnt4 = new Font("arial", 1, 40);
		
		
		g.setFont(fnt4);
		g.setColor(Color.white);
		g.drawString("Wave",  270,  70);
		
		g.setFont(fnt);
		g.drawRect(210,  150,  200,  64);
		g.drawString("Play",  290,  190);
		
		g.setFont(fnt);
		g.drawRect(210,  250,  200,  64);
		g.drawString("Help",  290,  290);
		
		g.drawRect(210,  350,  200,  64);
		g.drawString("Quit",  290,  390);
		
		
	}else if(game.gameState == STATE.Help)	{
		Font fnt = new Font("arial", 1, 20);
		Font fnt2 = new Font("arial", 1, 30);
		Font fnt3 = new Font("arial", 1, 15);
		Font fnt4 = new Font("arial", 1, 40);
		
		
		g.setFont(fnt4);
		g.setColor(Color.white);
		g.drawString("Help",  270,  70);
		
		g.setFont(fnt3);
		g.drawString("Press WASD keys to avoid enemies.", 180,100);
		
		g.setFont(fnt3);
		g.drawString( "Good luck!", 270,200);
		
		g.setFont(fnt3);
		g.drawString( "'First Game' by Krystal Maughan", 200,300);
		
		g.setFont(fnt);
		g.drawRect(210,  350,  200,  64);
		g.drawString("Back",  290,  390);
		
		
		

		
	}else if(game.gameState == STATE.End){
		Font fnt = new Font("arial", 1, 20);
		Font fnt2 = new Font("arial", 1, 30);
		Font fnt3 = new Font("arial", 1, 15);
		
		
		
		
		

		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over",  270,  70);	
		
		
		g.setFont(fnt3);
		g.drawString("You lost with a score of : " + hud.getScore(),210,100);
		
		g.setFont(fnt);
		g.drawRect(210,  350,  200,  64);
		g.drawString("Try Again",  270,  390);
			
		}
	else if(game.gameState == STATE.Menu){
			
			Font fnt = new Font("arial", 1, 20);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt4 = new Font("arial", 1, 40);
			
			
			g.setFont(fnt4);
			g.setColor(Color.white);
			g.drawString("Wave",  270,  70);
			
			g.setFont(fnt);
			g.drawRect(210,  150,  200,  64);
			g.drawString("Play",  290,  190);
			
			g.setFont(fnt);
			g.drawRect(210,  250,  200,  64);
			g.drawString("Help",  290,  290);
			
			g.drawRect(210,  350,  200,  64);
			g.drawString("Quit",  290,  390);
			
			
		}
	}

}
