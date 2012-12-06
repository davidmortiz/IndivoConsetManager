package org.indivohealth.exception

/**
 * @author David Ortiz
 * @date 9/4/12
 * @link http://cbmi.med.harvard.edu
 * @link http://chip.org
 *       <p/>
 *       NOTICE: This software comes with NO guarantees whatsoever and is
 *       licensed as Lgpl Open Source
 * @link http://www.gnu.org/licenses/lgpl.html
 */
class BadRequestException extends IndivoException{

  public BadRequestException(String message){
    super(message)
  }
}
