package features

import com.github.agourlay.cornichon.CornichonFeature

class HeadFeature extends CornichonFeature {
  def feature = Feature("HEAD request") {
    Scenario("return 200") {
      When I head("http://localhost:8080/hello")
      Then assert status.is(200)
    }
  }
}
