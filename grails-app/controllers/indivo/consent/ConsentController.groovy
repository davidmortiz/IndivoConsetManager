package indivo.consent

/**
 * @author David Ortiz
 * @date 11/28/12
 * @link http://cbmi.med.harvard.edu
 * @link http://chip.org
 *       <p/>
 *       NOTICE: This software comes with NO guarantees whatsoever and is
 *       licensed as Lgpl Open Source
 * @link http://www.gnu.org/licenses/lgpl.html
 */
class ConsentController {
    def indivoService

    def index = {
        def demographic = indivoService.demographics
        [demographic: session["demographic"]]
    }

    def enroll = {
        [demographic: session["demographic"]]
    }

}
