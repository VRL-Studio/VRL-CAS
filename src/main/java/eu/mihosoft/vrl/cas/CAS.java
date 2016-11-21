/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.cas;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.visual.VSwingUtil;
import java.io.Serializable;
import org.matheclipse.core.basic.Config;
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
        String[] result = {""};
        VSwingUtil.invokeAndWait(()->result[0]=getUtil().evaluate(input).toString());
        return result[0];
    }

    private ExprEvaluator getUtil() {
   
        if (util == null) {
            util = new ExprEvaluator(getEngine(), false, 100);
        }

        return util;
    }

    private EvalEngine getEngine() {
        if (engine == null) {
            Config.PARSER_USE_LOWERCASE_SYMBOLS = true;
            
            engine = new EvalEngine(true);
        }

        return engine;
    }

}
