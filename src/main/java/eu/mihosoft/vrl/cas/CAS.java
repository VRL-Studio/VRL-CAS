/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.cas;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import java.io.Serializable;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.ExprEvaluator;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
@ComponentInfo(name = "CAS", category = "VRL/Math/CAS")
public class CAS implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient EvalEngine engine;
    private transient ExprEvaluator util;

    public String process(@ParamInfo(name="Expression", style="code") String input) {
        return getUtil().evaluate(input).toString();
    }

    private ExprEvaluator getUtil() {
        if (util == null) {
            util = new ExprEvaluator(getEngine(), false, 100);
        }

        return util;
    }

    private EvalEngine getEngine() {
        if (engine == null) {
            engine = new EvalEngine(true);
        }

        return engine;
    }

}
