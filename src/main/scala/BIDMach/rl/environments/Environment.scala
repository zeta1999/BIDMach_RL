package BIDMach.rl.environments;

import BIDMat.{Mat,SBMat,CMat,DMat,FMat,IMat,LMat,HMat,GMat,GDMat,GIMat,GLMat,GSMat,GSDMat,SMat,SDMat}
import BIDMat.MatFunctions._
import BIDMat.SciFunctions._
import BIDMach.networks.layers._;
import BIDMach.networks._
import BIDMach.updaters._
import BIDMach._
import jcuda.jcudnn._
import jcuda.jcudnn.JCudnn._
import scala.util.hashing.MurmurHash3;
import java.util.HashMap;

@SerialVersionUID(100L)
abstract class Environment(val opts:Environment.Opts = new Environment.Options) extends Serializable {
  
  val VALID_ACTIONS:IMat;
  
  val limit_reward_incr:FMat;
  
  def step(action:Int):(FMat, Float, Boolean);
  
  def statedims:IMat;
  
  def lives():Int;
  
  def reset();
  
}

object Environment {
  
  trait Opts extends BIDMat.Opts {
  	var endEpochAtReward = false;
  	var endEpochAtDeath = false;
  	var random_seed = 0;
  	var limit_reward_incr = row(-1f,1f);
  }
  
  class Options extends Opts {
    
  }
}