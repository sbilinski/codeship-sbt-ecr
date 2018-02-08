package com.mintbeans

import org.scalatest._

class SimulationSpec extends WordSpec with Matchers with GivenWhenThen {
  "Simulation" should {
    "provide a proper answer" in {
      Given("a simulation instance")
      val simulation = new Simulation()

      When("the question of life the universe and everything is asked")
      val answer = simulation.lifeTheUniverseAndEverything()

      Then("the answer should be 42")
      answer shouldBe (42)
    }
  }
}
